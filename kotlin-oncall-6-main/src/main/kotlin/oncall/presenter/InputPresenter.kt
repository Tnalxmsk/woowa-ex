package oncall.presenter

import oncall.extensions.toQueue
import oncall.model.OncallDate
import oncall.model.OncallWorker
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

    fun onInputEmployee(): OncallWorker {
        while (true) {
            try {
                val weekdayWorkers = inputView.readWeekdayWorkers()
                val weekendWorkers = inputView.readWeekendWorkers()
                return OncallWorker(weekdayWorkers.toQueue(), weekendWorkers.toQueue())
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}