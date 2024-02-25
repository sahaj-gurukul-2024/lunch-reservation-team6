package gkl.exercise

import gkl.exercise.entities.EmployeeEntity
import gkl.exercise.models.Employee
import gkl.exercise.repository.EmployeeRepository
import gkl.exercise.services.LoginServices
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.*
import java.util.*

//@Requires(property = "EmployeeRepository.exclude=*" )
class LoginServiceUnitTest {

    private var employeeRepository:EmployeeRepository = Mockito.mock()

    private var loginServices :LoginServices = LoginServices(employeeRepository)

    @Test
    fun `add employee must return true for valid employee`(){
        val id = 1L
        val employee = Employee(id,"Sam")
        val empEntity = EmployeeEntity(id, "Sam")
        `when`(employeeRepository.findById(id))
            .thenReturn(Optional.of(empEntity))

        val res = loginServices.addEmployee(employee)

        verify(employeeRepository).update(empEntity)
        assert(res)
    }

    @Test
    fun `add employee should throw error for not found and save it`(){
        val id = 1L
        val employee = Employee(id,"Sam")
        val empEntity = EmployeeEntity(id, "Sam")
        `when`(employeeRepository.findById(id))
            .thenThrow(java.util.NoSuchElementException("No value present"))

        val res = loginServices.addEmployee(employee)
        verify(employeeRepository).save(any())

        assert(res)

    }

    @Test
    fun `add employee should throw exception when not able to save`(){
        val id = 1L
        val employee = Employee(id,"Sam")
        val empEntity = EmployeeEntity(id, "Sam")
        `when`(employeeRepository.findById(id))
            .thenThrow(RuntimeException())

        val res = loginServices.addEmployee(employee)

//        verify(employeeRepository).save(empEntity)
        assert(!res)
    }



}