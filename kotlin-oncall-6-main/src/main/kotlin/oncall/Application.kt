package oncall

import oncall.extensions.toQueue
import oncall.util.CalendarGenerator
import oncall.util.ScheduleGenerator
import oncall.view.InputView
import oncall.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val date = inputView.readDate().split(",")
    val month = date.first().toInt()
    val startDayOfWeek = date.last()
    val weekdayWorkers = inputView.readWeekdayWorkers().toQueue()
    val weekendWorkers = inputView.readWeekendWorkers().toQueue()
    val calendar = CalendarGenerator.generateCalendar(month, startDayOfWeek)
    val beforeSchedule = ScheduleGenerator.generateBeforeSchedule(weekdayWorkers, weekendWorkers,  month, calendar)
    val afterSchedule = ScheduleGenerator.generateAfterSchedule(beforeSchedule)
    for (worker in afterSchedule) {
        outputView.printDailyWorker(month, worker.day(), worker.dayOfWeek(), worker.workerName())
    }
}
