package oncall.util

import oncall.global.DayOfWeek.*
import oncall.global.Holiday
import oncall.model.DailyWorker
import oncall.model.Date
import oncall.model.Worker
import java.util.Queue

object ScheduleGenerator {
    fun generateBeforeSchedule(
        weekdayEmployee: Queue<String>,
        weekendEmployee: Queue<String>,
        month: Int,
        days: List<String>
    ): MutableList<DailyWorker> {
        val schedule = mutableListOf<DailyWorker>()
        for (index in days.indices) {
            val dayOfWeek = days[index]
            if (dayOfWeek == SATURDAY.value || dayOfWeek == SUNDAY.value || Holiday.isHoliday(month, index + 1)) {
                val dailyWorker = createDailyWorker(weekendEmployee, index + 1, dayOfWeek)
                schedule.add(dailyWorker)
                continue
            }
            val dailyWorker = createDailyWorker(weekdayEmployee, index + 1, dayOfWeek)
            schedule.add(dailyWorker)
        }
        return schedule
    }

    fun generateAfterSchedule(
        schedule: MutableList<DailyWorker>
    ): MutableList<DailyWorker> {
        for (index in schedule.indices) {
            if (index == 0 || index + 1 > schedule.lastIndex) continue
            val prevDailyWorker = schedule[index - 1]
            val nextDailyWorker = schedule[index + 1]
            schedule[index].changeWorker(prevDailyWorker, nextDailyWorker)
        }
        return schedule
    }

    private fun createDailyWorker(
        employees: Queue<String>,
        day: Int, weekOfDay: String
    ): DailyWorker {
        val name = employees.poll()!!
        val date = Date(day, weekOfDay)
        val worker = Worker(name)
        val dailyWorker = DailyWorker(date, worker)
        employees.add(name)
        return dailyWorker
    }
}