package gkl.exercise.repository

import gkl.exercise.entities.ReservationEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface ReservationRepository : CrudRepository<ReservationEntity,Long>{

    fun findByEmpid(id : Long) : ReservationEntity?
}