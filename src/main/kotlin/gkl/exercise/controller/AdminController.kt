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

    @Post("/date")
    fun showDate(@Body date: gkl.exercise.models.Date): Long {
        val dateCount = adminService.displayDateCount(date)
        return dateCount
    }

    
    @Post
    fun getOnDate(@Body date: Admin): HttpResponse<List<String>> {
        return try {
            HttpResponse.ok(adminService.getEmployeeOnDate(date.date))
        } catch (err: Exception) {
            HttpResponse.status(500,err.message)
        }
    }
    
}

