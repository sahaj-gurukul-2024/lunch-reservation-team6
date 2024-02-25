package gkl.exercise.repository

import gkl.exercise.entities.ReservationEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.Date

@Repository
interface ReservationRepository : CrudRepository<ReservationEntity,Long>{

    fun findByEmpid(id : Long) : ReservationEntity?

    fun countByDate(date: Date): Long

    fun findAllByDate(date: Date): List<ReservationEntity>

    fun findByDate(date: Date): List<ReservationEntity>

    fun findByEmpidAndDate(empId : Long,date : Date) : ReservationEntity?

}