package gkl.exercise

import gkl.exercise.models.Employee
import gkl.exercise.services.LoginServices
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject

@Controller("/api/login")

class LoginController(@Inject private val loginServices: LoginServices) {

    @Post(consumes = [MediaType.APPLICATION_JSON])
    fun validateUser(@Body employee: Employee): HttpStatus{

        if (loginServices.isPresent(employee)) return HttpStatus.OK

        return HttpStatus.NOT_FOUND
    }

}