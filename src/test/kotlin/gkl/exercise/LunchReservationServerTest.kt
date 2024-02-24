package gkl.exercise

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import gkl.exercise.models.Employee
import gkl.exercise.models.PrimaryComposite
import gkl.exercise.models.Reservation
import gkl.exercise.repository.EmployeeRepository
import gkl.exercise.repository.ReservationRepository
import gkl.exercise.services.LoginServices
import io.micronaut.http.HttpStatus
import io.micronaut.serde.ObjectMapper
import io.mockk.mockk
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.E

@MicronautTest
class LunchReservationServerTest(@Client("/") val client: HttpClient, val objectMapper: ObjectMapper) {

    @Inject
    lateinit var loginController: LoginController

    @Inject
    lateinit var reservationController: ReservationController

    @Inject
    lateinit var loginServices: LoginServices

    @Inject
    lateinit var employeeRepository: EmployeeRepository

    @Inject
    lateinit var reservationRepository: ReservationRepository

    @Test
    fun testHello() {
        val request: HttpRequest<Any> = HttpRequest.GET("/hello")
        val body = client.toBlocking().retrieve(request)
        assertEquals("Hello World", body)
    }

    @Test
    fun `Should Give 200 when employee gives correct details`() {

        val employee = Employee(id = 1, name = "Vaibhav")
        val httpResponse = loginController.validateUser(employee)
        assertEquals(200, httpResponse.status.code)
    }

    @Test
    fun `Should be able to login with same id but different name`() {
        val employee = Employee(id= 1, name = "Selva")
        val httpResponse = loginController.validateUser(employee)
        assertEquals(200, httpResponse.status.code)
    }

    @Test
    fun `Override name of the employee when logging in with same id but different name`() {
        val employee1 = Employee(id=10, name="ragul")
        val employee2 = Employee(id=10, name = "Madhvesh")
        var httpResponse = loginController.validateUser(employee1)
        httpResponse = loginController.validateUser(employee2)
        assertEquals("Madhvesh", employeeRepository.findById(10).get().name)
    }

    @Test
    fun `Should be able to reserve lunch for any day and existing employee`() {
        val employee = Employee(id = 101, name = "Madhvesh")
        var httpResponse = loginController.validateUser(employee)
        val reservation = Reservation(PrimaryComposite(101, "22-02-2024"),"Madhvesh", true)
        httpResponse = reservationController.reserveUser(reservation)
        assertEquals(200, httpResponse.status.code)
    }

    @Test
    fun `Should be able to override the status for a given employee id and date`() {
        val employee = Employee(id = 102, name = "Sanjeev")
        var httpResponse = loginController.validateUser(employee)
        val reservation1 = Reservation(PrimaryComposite(102, "22-02-2024"),"Sanjeev", true)
        httpResponse = reservationController.reserveUser(reservation1)
        val reservation2 = Reservation(PrimaryComposite(102, "22-02-2024"),"Sanjeev", false)
        httpResponse = reservationController.reserveUser(reservation2)
        val primaryKey = PrimaryComposite(102, "22-02-2024")
        assertEquals(false, reservationRepository.findById(primaryKey).get().status)
    }

}
