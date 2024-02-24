package gkl.exercise.services

import gkl.exercise.models.Reservation
import gkl.exercise.repository.ReservationRepository
import jakarta.inject.Singleton

@Singleton
class ReservationService(private val reservationRepository: ReservationRepository) {
    private val reservationList = mutableMapOf<Pair<Long, String>, Reservation>()

    init {
        val res = reservationRepository.findAll()
        res.forEach {
            reservationList[Pair(it.id, it.reserve)] = it
        }
    }

    fun addReservation(reservation: Reservation) {
        reservationList[Pair(reservation.id, reservation.reserve)] = reservation
        reservationRepository.save(reservation)
        println("List: $reservationList")
    }
}