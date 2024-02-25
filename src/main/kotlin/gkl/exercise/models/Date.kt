package gkl.exercise.models

import io.micronaut.serde.annotation.Serdeable
import java.util.Date

@Serdeable
data class Date(val date: Date) {
}