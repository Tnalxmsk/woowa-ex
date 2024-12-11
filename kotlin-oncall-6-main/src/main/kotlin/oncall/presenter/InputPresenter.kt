package oncall.presenter

import oncall.extensions.getDayOfWeek
import oncall.extensions.getMonth
import oncall.extensions.toWorkerQueue
import oncall.model.OncallDate
import oncall.model.OncallWorker
import oncall.validation.DateValidator
import oncall.validation.WorkerValidator
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

    fun onInputWorker(): OncallWorker {
        while (true) {
            try {
                val weekdayWorkers = inputView.readWeekdayWorkers()
                val weekendWorkers = inputView.readWeekendWorkers()
                return validateWorker(weekdayWorkers, weekendWorkers)
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

    private fun validateWorker(weekdayWorkers: String, weekendWorkers: String): OncallWorker {
        WorkerValidator.validateCommonInput(weekdayWorkers)
        WorkerValidator.validateCommonInput(weekendWorkers)
        WorkerValidator.validateEachWorkers(weekdayWorkers)
        WorkerValidator.validateEachWorkers(weekendWorkers)
        WorkerValidator.validateAllWorkers(weekdayWorkers.split(","), weekendWorkers.split(","))
        return OncallWorker(weekdayWorkers.toWorkerQueue(), weekendWorkers.toWorkerQueue())

    }
}