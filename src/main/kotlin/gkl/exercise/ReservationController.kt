package gkl.exercise

import gkl.exercise.models.Employee
import gkl.exercise.models.Reservation
import gkl.exercise.services.LoginServices
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject

@Controller("api/reservation")
class ReservationController(@Inject val loginServices: LoginServices) {
    @Post(consumes = [MediaType.APPLICATION_JSON])
    fun reserveUser(@Body reservation: Reservation): HttpResponse<Employee>{
        loginServices.addReservation(reservation)
        return HttpResponse.ok()
    }

}