package oncall.presenter

import oncall.model.AllocationDate
import oncall.view.InputView

class InputPresenter(
    private val inputView: InputView,
) {

    fun onInputDate(): AllocationDate {
        while (true) {
            try {
                val date = inputView.readDate().split(",")
                val allocationDate = AllocationDate(date.first().toInt(), date.last())
                return allocationDate
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun onInputEmployee(): Pair<List<String>, List<String>> {
        while (true) {
            try {
                val weekdayEmployee = inputView.readWeekdayWorkers()
                val weekendEmployee = inputView.readWeekendWorkers()
                return Pair(weekdayEmployee, weekendEmployee)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}