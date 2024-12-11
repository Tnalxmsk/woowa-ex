package oncall.config

import oncall.OncallApplication
import oncall.view.InputView
import oncall.view.OutputView

object ApplicationFactory {
    fun createOnCallApplication(): OncallApplication {
        val inputView = InputView()
        val outputView = OutputView()
        return OncallApplication(inputView, outputView)
    }
}