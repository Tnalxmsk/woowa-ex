package oncall.model

import oncall.util.CalendarGenerator

class OncallDate(
    private val month: Int,
    private val startDayOfWeek: String,
) {
    private var calendar: List<String> = CalendarGenerator.generateCalendar(month, startDayOfWeek)


    fun getMonth(): Int = month

    fun getCalendar(): List<String> = calendar
}