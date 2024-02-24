package gkl.exercise.repository

import gkl.exercise.models.PrimaryComposite
import gkl.exercise.models.Reservation
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

@JdbcRepository(dialect = Dialect.POSTGRES)
interface ReservationRepository : CrudRepository<Reservation, PrimaryComposite>{
}