package oncall.util

import oncall.global.DayOfWeek.*
import java.util.Queue

object ScheduleGenerator {
    fun generateBeforeSchedule(
        weekdayEmployee: Queue<String>,
        weekendEmployee: Queue<String>,
        days: List<String>
    ): List<String> {
        val schedule = mutableListOf<String>()
        for (dayOfWeek in days) {
            if (dayOfWeek == SATURDAY.value || dayOfWeek == SUNDAY.value) {
                val employee = weekendEmployee.poll()!!
                println("주말 - $employee")
                schedule.add(employee)
                weekendEmployee.add(employee)
            } else {
                val employee = weekdayEmployee.poll()!!
                println("평일 - $employee")
                schedule.add(employee)
                weekdayEmployee.add(employee)
            }
        }
        return schedule
    }
}