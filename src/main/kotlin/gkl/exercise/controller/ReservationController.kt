package gkl.exercise.controller

import gkl.exercise.models.Reservation
import gkl.exercise.services.ReservationService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Post

@Controller("/api")
class ReservationController(private val reservationService: ReservationService){

    @Post("/reserve")
    fun reserveDate(@Body reservation: Reservation) : HttpResponse<String>{
        try {
            reservationService.reserveDate(reservation.id, reservation.date)
            return HttpResponse.ok()
        }
        catch(err : Exception){
            return HttpResponse.status(500,"Internal server error date not updated")
        }
    }

    @Post("/unreserve")
    fun unReserveDate(@Body reservation: Reservation) : HttpResponse<String>{

        try {
            reservationService.unReserveDate(reservation.id, reservation.date)
            return HttpResponse.ok()
        }
        catch(err : Exception){
            return HttpResponse.status(500,"Internal server error date not updated")
        }
    }

    @Post("/is-reserved")
    fun isReserved(@Body reservation: Reservation) : HttpResponse<Boolean>{

        try{
            return HttpResponse.ok(reservationService.isReserved(reservation.id,reservation.date))
        }

        catch (err : Exception){
            return HttpResponse.status(500,"Internal server error")
        }
    }
}