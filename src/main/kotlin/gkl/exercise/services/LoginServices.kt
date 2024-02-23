package gkl.exercise.services

import gkl.exercise.models.Employee
import jakarta.inject.Singleton

@Singleton
class LoginServices {
    private val employeeList = mutableMapOf<Int,Employee>()

    fun isPresent(employee: Employee): Boolean{

        if (employeeList.containsKey(employee.id)){
            return employeeList.get(employee.id)!!.name == employee.name
        }
        else{
            employeeList[employee.id] = employee
            return true
        }
    }
}