package oncall.presenter

import oncall.model.OncallDate
import oncall.model.DailyWorker
import oncall.view.OutputView

class OutputPresenter(
    private val outputView: OutputView
) {

    fun showSchedule(oncallDate: OncallDate, schedule: List<DailyWorker>) {
        for (worker in schedule) {
            outputView.printDailyWorker(oncallDate.getMonth(), worker.day(), worker.dayOfWeek(), worker.workerName())
        }
    }
}