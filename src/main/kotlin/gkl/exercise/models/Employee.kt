package gkl.exercise.models

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Employee(val id: Int, val name: String);
