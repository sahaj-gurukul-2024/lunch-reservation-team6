package gkl.exercise.services

import gkl.exercise.entities.ReservationEntity
import gkl.exercise.repository.EmployeeRepository
import gkl.exercise.repository.ReservationRepository
import jakarta.inject.Singleton
import java.util.*

@Singleton
class ReservationService(private val reservationRepository: ReservationRepository, private val employeeRepository: EmployeeRepository) {

    fun reserveDate(id: Long, date: Date) {
        for(reservation in reservationRepository.findAllByDate(date))
        {
            if(reservation.empid == id)
                return
        }
        if(employeeRepository.findById(id) != null)
            employeeRepository.findById(id).get().id
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

    fun isReserved(id : Long,date : Date) : Boolean{
        return reservationRepository.findByEmpidAndDate(id,date)!=null
    }
}