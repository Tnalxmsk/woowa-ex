package oncall.util

import oncall.global.Date
import oncall.global.DayOfWeek
import oncall.global.Holiday

object CalendarGenerator {
    fun generateCalendar(month: Int, startDayOfWeek: String): List<String> {
        val date = Date.from(month)
        val dayOfWeek = DayOfWeek.from(startDayOfWeek)
        val days = mutableListOf<String>()
        for (day in 1..date.days) {
            val nowDayOfWeek = DayOfWeek.entries[(dayOfWeek.ordinal + (day - 1)) % 7]
            if (Holiday.isHoliday(month, day) && DayOfWeek.isWeekday(nowDayOfWeek.value)) {
                days.add("${nowDayOfWeek.value}(휴일)")
                continue
            }
            days.add(nowDayOfWeek.value)
        }

        return days
    }
}