package gkl.exercise.services

import gkl.exercise.models.PrimaryComposite
import gkl.exercise.models.Reservation
import gkl.exercise.repository.ReservationRepository
import jakarta.inject.Singleton

@Singleton
class ReservationService(private val reservationRepository: ReservationRepository) {
    private val reservationList = mutableMapOf<PrimaryComposite, Reservation>()

    init {
        val res = reservationRepository.findAll()
        res.forEach {
            reservationList[PrimaryComposite(it.compositeKey.id, it.compositeKey.reserve)] = it
        }
    }

    fun addReservation(reservation: Reservation) {
        if(reservationList.containsKey(PrimaryComposite(reservation.compositeKey.id, reservation.compositeKey.reserve)))
            reservationRepository.deleteById(PrimaryComposite(reservation.compositeKey.id, reservation.compositeKey.reserve))
        reservationList[PrimaryComposite(reservation.compositeKey.id, reservation.compositeKey.reserve)] = reservation
        reservationRepository.save(reservation)
        println("List: $reservationList")
    }
}