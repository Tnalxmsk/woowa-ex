package oncall.presenter

import oncall.model.OncallDate
import oncall.view.InputView

class InputPresenter(
    private val inputView: InputView,
) {

    fun onInputDate(): OncallDate {
        while (true) {
            try {
                val date = inputView.readDate().split(",")
                val oncallDate = OncallDate(date.first().toInt(), date.last())
                return oncallDate
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