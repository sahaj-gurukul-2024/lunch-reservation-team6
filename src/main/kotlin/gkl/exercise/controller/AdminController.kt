package gkl.exercise.controller

import gkl.exercise.models.Admin
import gkl.exercise.services.AdminService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import java.util.Date

@Controller("/admin")
class AdminController(private val adminService: AdminService) {

    @Post
    fun getOnDate(@Body date: Admin): HttpResponse<List<String>> {
        return try {
            HttpResponse.ok(adminService.getEmployeeOnDate(date.date))
        } catch (err: Exception) {
            HttpResponse.status(500,err.message)
        }
    }
}