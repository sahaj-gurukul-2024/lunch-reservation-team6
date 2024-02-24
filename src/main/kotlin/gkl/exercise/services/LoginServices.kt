package gkl.exercise.services

import gkl.exercise.entities.EmployeeEntity
import gkl.exercise.models.Employee
import gkl.exercise.repository.EmployeeRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class LoginServices (@Inject private val employeeRepository: EmployeeRepository){


    fun addEmployee(employee: Employee) : Boolean{

        try {
            val emp : EmployeeEntity = employeeRepository.findById(employee.id).get()
            emp.name=employee.name
            employeeRepository.update(emp)
            return true
        }
        catch(err : NoSuchElementException){
            employeeRepository.save(EmployeeEntity(employee.id,employee.name))
            return true
        }
        catch(err : Exception){
            println(err)
            return false
        }
    }

}