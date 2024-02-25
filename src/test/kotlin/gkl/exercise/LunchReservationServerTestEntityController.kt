package gkl.exercise
import gkl.exercise.controller.LoginController
import gkl.exercise.controller.ReservationController
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import gkl.exercise.models.Employee
import gkl.exercise.models.Reservation
import gkl.exercise.repository.EmployeeRepository
import gkl.exercise.services.LoginServices
import io.micronaut.serde.ObjectMapper
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.Date

@MicronautTest
class LunchReservationServerTestEntityController(@Client("/") val client: HttpClient, val objectMapper: ObjectMapper) {
    @Inject
    lateinit var loginController: LoginController

    @Inject
    lateinit var reservationController: ReservationController

    @Inject
    lateinit var employeeRepository: EmployeeRepository

    @Test
    fun testHello() {
        val request: HttpRequest<Any> = HttpRequest.GET("/hello")
        val body = client.toBlocking().retrieve(request)
        assertNotNull(body)
        assertEquals("Hello World", body)
    }

    @Test
    fun `Should Give 200 when employee gives correct details`(){

        val employee = Employee(id = 1, name = "Vaibhav")
        val res = loginController.validateUser(employee)
        assertEquals(200, res.status.code)
    }

    @Test
    fun `Should Give 200 when 2 employees are entered with same id`(){

        val employee1 = Employee(id = 1, name = "Vaibhav")
        val employee2 = Employee(id = 1, name = "Madhvesh")
        loginController.validateUser(employee1)
        val res = loginController.validateUser(employee2)
        assertEquals(200, res.status.code)
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
    fun `An existing employee should be able to reserve lunch for any day`() {
        val employee = Employee(id = 101, name = "Madhvesh")
        loginController.validateUser(employee)
        val reservation = Reservation(id = 101, date = Date(124, 3, 23))
        val httpResponse = reservationController.reserveDate(reservation)
        assertEquals(200, httpResponse.status.code)
    }

    @Test
    fun `Single employee reserving lunch for single date multiple times should not create redundant records`() {
        val employee = Employee(id = 102, name = "Madhvesh")
        loginController.validateUser(employee)
        val reservation1 = Reservation(id = 102, date = Date(124, 3, 23))
        reservationController.reserveDate(reservation1)
        reservationController.reserveDate(reservation1)
    }

}
