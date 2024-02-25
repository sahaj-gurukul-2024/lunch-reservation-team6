package gkl.exercise.models

import io.micronaut.http.annotation.Controller
import io.micronaut.serde.annotation.Serdeable
import java.util.Date

@Serdeable
data class Reservation(val id : Long,val date : Date)