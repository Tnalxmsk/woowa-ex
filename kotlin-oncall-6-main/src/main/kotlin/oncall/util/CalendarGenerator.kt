package oncall.util

import oncall.global.Date
import oncall.global.DayOfWeek

object CalendarGenerator {
    fun generateCalendar(month: Int, startDayOfWeek: String): List<String> {
        val date = Date.from(month)
        val dayOfWeek = DayOfWeek.from(startDayOfWeek)
        val days = mutableListOf<String>()
        for (day in 1..date.days) {
            val nowDayOfWeek = DayOfWeek.entries[(dayOfWeek.ordinal + (day - 1)) % 7]
            days.add(nowDayOfWeek.value)
        }

        return days
    }
}