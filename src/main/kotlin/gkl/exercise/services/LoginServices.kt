package gkl.exercise.services

import gkl.exercise.models.Employee
import gkl.exercise.models.Reservation
import gkl.exercise.repository.EmployeeRepository
import gkl.exercise.repository.ReservationRepository
import jakarta.inject.Singleton

@Singleton
class LoginServices(private val employeeRepository: EmployeeRepository) {
    private val employeeList = mutableMapOf<Long, Employee>()

    init {
        val list = employeeRepository.findAll()
        list.forEach { it ->
            employeeList[it.id] = it
        }
    }

    fun addUser(employee: Employee) {
        if(employeeList.containsKey(employee.id))
            employeeRepository.deleteById(employee.id)
        employeeList[employee.id] = employee
        employeeRepository.save(employee)
    }
}