package oncall.validation

import oncall.extensions.invalidWorkerNameLength
import oncall.extensions.invalidWorkerRule
import oncall.extensions.isWorkersSizeInvalid
import oncall.global.Error.*

object WorkerValidator {

    fun validateCommonInput(input: String) {
        val error = when {
            input.isEmpty() -> INVALID_INPUT
            input.contains(" ") -> INVALID_INPUT
            else -> return
        }
        throw IllegalArgumentException(error.message)
    }

    fun validateEachWorkers(input: String) {
        val workers = input.split(",")
        val error = when {
            workers.size != workers.toSet().size -> INVALID_INPUT
            workers.isWorkersSizeInvalid() -> INVALID_INPUT
            workers.invalidWorkerNameLength() -> INVALID_INPUT
            else -> return
        }
        throw IllegalArgumentException(error.message)
    }

    fun validateAllWorkers(weekdayWorker: List<String>, weekendWorker: List<String>) {
        val error = when {
            weekdayWorker.size != weekendWorker.size -> INVALID_INPUT
            weekdayWorker.invalidWorkerRule(weekendWorker) -> INVALID_INPUT
            else -> return
        }
        throw IllegalArgumentException(error.message)
    }
}