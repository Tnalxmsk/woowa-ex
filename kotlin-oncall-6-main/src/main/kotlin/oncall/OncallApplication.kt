package oncall

import oncall.extensions.toQueue
import oncall.model.OncallDate
import oncall.model.DailyWorker
import oncall.presenter.InputPresenter
import oncall.presenter.OutputPresenter
import oncall.util.CalendarGenerator
import oncall.util.ScheduleGenerator
import oncall.view.InputView
import oncall.view.OutputView
import java.util.Queue

class OncallApplication(
    private val inputView: InputView,
    private val outputView: OutputView,
) {

    fun run() {
        val inputPresenter = createInputPresenter()
        val outputPresenter = createOutputPresenter()

        val allocationDate = inputPresenter.onInputDate()
        val employees = inputPresenter.onInputEmployee()
        val weekdayEmployee = employees.first.toQueue()
        val weekendEmployee = employees.second.toQueue()

        val schedule = createSchedule(allocationDate, weekdayEmployee, weekendEmployee)
        outputPresenter.showSchedule(allocationDate, schedule)
    }

    private fun createInputPresenter(): InputPresenter {
        return InputPresenter(inputView)
    }

    private fun createOutputPresenter(): OutputPresenter {
        return OutputPresenter(outputView)
    }

    private fun createSchedule(
        oncallDate: OncallDate,
        weekdayEmployee: Queue<String>,
        weekendEmployee: Queue<String>
    ): MutableList<DailyWorker> {
        val calendar = CalendarGenerator.generateCalendar(oncallDate.month, oncallDate.dayOfWeek)
        val beforeSchedule =
            ScheduleGenerator.generateBeforeSchedule(weekdayEmployee, weekendEmployee, oncallDate.month, calendar)
        val afterSchedule = ScheduleGenerator.generateAfterSchedule(beforeSchedule)
        return afterSchedule
    }
}