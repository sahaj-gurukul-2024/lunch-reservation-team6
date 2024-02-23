package gkl.exercise.services

import gkl.exercise.models.Employee
import jakarta.inject.Singleton

@Singleton
class LoginServices {
    private val employeeList = mutableMapOf<Long,Employee>()

    fun addUser(employee: Employee){
        if (employeeList.containsKey())
    }

}