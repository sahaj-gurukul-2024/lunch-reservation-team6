package gkl.exercise.models

import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.serde.annotation.Serdeable


@MappedEntity
@Serdeable
data class Employee (

    @Id
    val id: Long,
    val name: String
);