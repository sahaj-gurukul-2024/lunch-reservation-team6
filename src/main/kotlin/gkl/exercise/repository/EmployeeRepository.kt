package gkl.exercise.repository

import gkl.exercise.entities.EmployeeEntity
import io.micronaut.data.annotation.Repository

import io.micronaut.data.repository.CrudRepository

@Repository
interface EmployeeRepository : CrudRepository<EmployeeEntity, Long>{

}