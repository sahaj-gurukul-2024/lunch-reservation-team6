package gkl.exercise.controller

import gkl.exercise.models.Dates
import gkl.exercise.services.AdminServices
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.HttpResponse
import java.util.Date

@Controller("/admin")
class AdminController(private val adminService: AdminServices){
    @Post("/week")
    fun showWeek(@Body Dates: Dates): MutableMap<Date, Long> {
        val dateToCount = adminService.displayWeek(Dates)
        return dateToCount
    }

}