package gkl.exercise.services

import gkl.exercise.repository.EmployeeRepository
import gkl.exercise.repository.ReservationRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.util.Date

@Singleton
class AdminService(@Inject private val reservationRepository: ReservationRepository, @Inject private val employeeRepository: EmployeeRepository) {

    fun getEmployeeOnDate(date: Date): List<String> {
        val reservationEntityList = reservationRepository.findByDate(date)
        val empNames = mutableListOf<String>()
        for (each in reservationEntityList) {
            empNames.add(employeeRepository.findById(each.empid).get().name)
        }
        return empNames
    }
}