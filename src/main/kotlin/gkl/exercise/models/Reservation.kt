package gkl.exercise.models

import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.serde.annotation.Serdeable

@MappedEntity
@Serdeable
data class Reservation(@Id val id: Long, val name: String, val reserve: String, val status: Boolean) {
}