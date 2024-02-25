package gkl.exercise.models

import io.micronaut.serde.annotation.Serdeable
import java.util.Date

@Serdeable
data class Admin(val date: Date)