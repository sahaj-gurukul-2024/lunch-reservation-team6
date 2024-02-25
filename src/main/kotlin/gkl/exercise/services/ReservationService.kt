package gkl.exercise.services

import gkl.exercise.entities.ReservationEntity
import gkl.exercise.repository.ReservationRepository
import jakarta.inject.Singleton
import java.util.*

@Singleton
class ReservationService(private val reservationRepository: ReservationRepository) {

    fun reserveDate(id: Long, date: Date) {
        for(reservation in reservationRepository.findAllByDate(date))
        {
            if(reservation.id == id)
                return
        }
        reservationRepository.save(ReservationEntity(id, date))
    }

    fun unReserveDate(id: Long, date: Date): Boolean {

        try {
            val emp : ReservationEntity? = reservationRepository.findByEmpid(id)
            if (emp != null) reservationRepository.delete(emp)
            return true
        }
        catch (err: Exception) {
            return false
        }

    }
}