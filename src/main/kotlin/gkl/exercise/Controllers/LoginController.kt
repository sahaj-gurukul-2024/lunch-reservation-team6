package gkl.exercise.Controllers

import gkl.exercise.models.Employee
import gkl.exercise.services.LoginServices
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject

@Controller("/api/login")

class LoginController( @Inject val loginServices: LoginServices) {

    @Post(consumes = [MediaType.APPLICATION_JSON])
    fun validateUser(@Body employee: Employee): HttpResponse<Employee>{

        loginServices.addUser(employee)
        return HttpResponse.ok()
    }

}