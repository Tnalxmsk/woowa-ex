package oncall.presenter

import oncall.extensions.getDayOfWeek
import oncall.extensions.getMonth
import oncall.extensions.toWorkerQueue
import oncall.model.OncallDate
import oncall.model.OncallWorker
import oncall.validation.DateValidator
import oncall.view.InputView

class InputPresenter(
    private val inputView: InputView,
) {

    fun onInputDate(): OncallDate {
        while (true) {
            try {
                val date = inputView.readDate()
                return validateDate(date)
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
                return OncallWorker(weekdayWorkers.toWorkerQueue(), weekendWorkers.toWorkerQueue())
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun validateDate(date: String): OncallDate {
        DateValidator.validateCommonInput(date)
        DateValidator.validateMonth(date.getMonth())
        DateValidator.validateDayOfWeek(date.getDayOfWeek())
        return OncallDate(date.getMonth().toInt(), date.getDayOfWeek())
    }
}