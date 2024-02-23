package gkl.exercise
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import gkl.exercise.models.Employee
import gkl.exercise.services.LoginServices
import io.micronaut.http.HttpStatus
import io.micronaut.serde.ObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@MicronautTest
class LunchReservationServerTest(@Client("/") val client: HttpClient, val objectMapper: ObjectMapper) {

    @Test
    fun testHello() {
        val request: HttpRequest<Any> = HttpRequest.GET("/hello")
        val body = client.toBlocking().retrieve(request)



        assertNotNull(body)
        assertEquals("Hello World", body)
    }

    @Test
    fun `Should Give 200 when employee gives correct details`(){

        val loginServices = LoginServices()
        val loginController = LoginController(loginServices)
        val employee = Employee(id = 1, name = "Vaibhav")
        val res = loginController.validateUser(employee)
        println(res.code)
        assertEquals(200, res.code)
    }

    @Test
    fun `Should Give 404 when employee gives correct details`(){

        val loginServices = LoginServices()
        val loginController = LoginController(loginServices)
        val employee1 = Employee(id = 1, name = "Vaibhav")
        val employee2 = Employee(id = 1, name = "Madhvesh")
        loginController.validateUser(employee1)
        val res = loginController.validateUser(employee2)

        println(res.code)
        assertEquals(404, res.code)
    }

}
