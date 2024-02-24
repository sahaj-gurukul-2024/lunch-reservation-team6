package gkl.exercise

import gkl.exercise.models.Employee
import gkl.exercise.models.Reservation
import gkl.exercise.services.LoginServices
import gkl.exercise.services.ReservationService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject

@Controller("api/reservation")
class ReservationController(@Inject val reservationServices: ReservationService) {
    @Post(consumes = [MediaType.APPLICATION_JSON])
    fun reserveUser(@Body reservation: Reservation): HttpResponse<Employee>{
        reservationServices.addReservation(reservation)
        return HttpResponse.ok()
    }

}