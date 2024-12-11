package oncall.presenter

import oncall.model.AllocationDate
import oncall.model.DailyWorker
import oncall.view.OutputView

class OutputPresenter(
    private val outputView: OutputView
) {

    fun showSchedule(allocationDate: AllocationDate, schedule: List<DailyWorker>) {
        for (worker in schedule) {
            outputView.printDailyWorker(allocationDate.month, worker.day(), worker.dayOfWeek(), worker.workerName())
        }
    }
}