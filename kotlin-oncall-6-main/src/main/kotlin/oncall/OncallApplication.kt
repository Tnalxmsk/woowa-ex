package oncall

import oncall.presenter.InputPresenter
import oncall.presenter.OncallPresenter
import oncall.presenter.OutputPresenter

class OncallApplication(
    private val inputPresenter: InputPresenter,
    private val outputPresenter: OutputPresenter,
    private val oncallPresenter: OncallPresenter,
) {

    fun run() {
        val allocationDate = inputPresenter.onInputDate()
        val oncallWorker = inputPresenter.onInputEmployee()

        val oldSchedule = oncallPresenter.createBeforeSchedule(allocationDate, oncallWorker)
        val newSchedule = oncallPresenter.createAfterSchedule(oldSchedule)

        outputPresenter.showSchedule(allocationDate, newSchedule)
    }
}