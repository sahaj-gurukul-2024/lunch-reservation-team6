package gkl.exercise.services

import gkl.exercise.models.Dates
import gkl.exercise.repository.ReservationRepository
import jakarta.inject.Singleton
import java.util.Calendar
import java.util.Date

@Singleton
class AdminServices(private val reservationRepository: ReservationRepository) {
    private val dateToCount = mutableMapOf<Date, Long>()
    fun displayWeek(date: Dates): MutableMap<Date, Long> {
        val startDate = date.startDate
        val endDate = date.endDate
        val calendar = Calendar.getInstance()
        calendar.time = startDate
        for(dateCount in 0..7)
        {
            if(calendar.time >= endDate) break
            dateToCount[calendar.time] = reservationRepository.countByDate(calendar.time)
            calendar.add(Calendar.DAY_OF_WEEK, 1)
        }
        return dateToCount
    }

    fun displayDateCount(date: gkl.exercise.models.Date): Long {
        return reservationRepository.countByDate(date.date)
    }
}