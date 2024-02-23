package gkl.exercise.services

import gkl.exercise.models.Employee
import gkl.exercise.repository.EmployeeRepository
import jakarta.inject.Singleton

@Singleton
class LoginServices (private val employeeRepository: EmployeeRepository){
    private val employeeList = mutableMapOf<Long,Employee>()

    init {
        val list = employeeRepository.findAll()
        list.forEach { it->
            employeeList[it.id] = it
        }
    }
    fun addUser(employee: Employee){
        employeeList.containsKey(employee.id)
        employeeList[employee.id] = employee
        employeeRepository.updateAll(employeeList.values)
        println(employeeList)
        println(employeeRepository.findAll())
    }

}