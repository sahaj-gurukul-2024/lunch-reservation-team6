package gkl.exercise
import gkl.exercise.controller.LoginController
import gkl.exercise.models.Employee
import gkl.exercise.services.LoginServices
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.serde.ObjectMapper
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@MicronautTest
class LunchReservationServerTestEntityController(@Client("/") val client: HttpClient, val objectMapper: ObjectMapper) {

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

        val request: HttpRequest<Any> = HttpRequest.POST("/api/login",employee)
        val response: HttpResponse<Any> = client.toBlocking().exchange(request)

        assertEquals(200, response.code())
    }


}
