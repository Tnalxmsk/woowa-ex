package oncall.config

import oncall.OncallApplication
import oncall.presenter.InputPresenter
import oncall.presenter.OncallPresenter
import oncall.presenter.OutputPresenter
import oncall.view.InputView
import oncall.view.OutputView

object ApplicationFactory {
    fun createOnCallApplication(): OncallApplication {
        val inputPresenter = createInputPresenter()
        val outputPresenter = createOutputPresenter()
        val oncallPresenter = createOncallPresenter()
        return OncallApplication(inputPresenter, outputPresenter, oncallPresenter)
    }

    private fun createInputPresenter(): InputPresenter {
        val inputView = InputView()
        return InputPresenter(inputView)
    }

    private fun createOutputPresenter(): OutputPresenter {
        val outputView = OutputView()
        return OutputPresenter(outputView)
    }

    private fun createOncallPresenter(): OncallPresenter {
        return OncallPresenter()
    }
}