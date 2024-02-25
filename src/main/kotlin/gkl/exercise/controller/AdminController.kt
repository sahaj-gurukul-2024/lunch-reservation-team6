package gkl.exercise.controller

import gkl.exercise.services.AdminServices
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import java.util.Date

@Controller("/admin")
class AdminController(private val adminService: AdminServices){
    @Post("/week")
    fun showWeek(startDate: Date) {

    }

}