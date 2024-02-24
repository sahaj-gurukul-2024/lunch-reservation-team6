package gkl.exercise
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import gkl.exercise.models.Employee
import gkl.exercise.services.LoginServices
import io.micronaut.http.HttpStatus
import io.micronaut.serde.ObjectMapper
import io.mockk.mockk
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@MicronautTest
class LunchReservationServerTest(@Client("/") val client: HttpClient, val objectMapper: ObjectMapper) {

    @Inject
    lateinit var loginController: LoginController
    @Inject
    lateinit var loginServices: LoginServices
    @Test
    fun testHello() {
        val request: HttpRequest<Any> = HttpRequest.GET("/hello")
        val body = client.toBlocking().retrieve(request)



//        assertNotNull(body)
        assertEquals("Hello World", body)
    }

    @Test
    fun `Should Give 200 when employee gives correct details`(){

        val employee = Employee(id = 1, name = "Vaibhav")
        val httpResponse = loginController.validateUser(employee)
        assertEquals(200, httpResponse.status.code)
    }

}
