package oncall.validation

import oncall.global.DayOfWeek
import oncall.global.Error

object DateValidator {

    fun validateCommonInput(input: String) {
        val error = when {
            input.isEmpty() -> Error.INVALID_INPUT
            input.contains(" ") -> Error.INVALID_INPUT
            else -> return
        }
        throw IllegalArgumentException(error.message)
    }

    fun validateMonth(input: String) {
        val error = when {
            Regex("^(1[0-2]|[1-9])$").matches(input).not() -> Error.INVALID_INPUT
            else -> return
        }
        throw IllegalArgumentException(error.message)
    }

    fun validateDayOfWeek(input: String) {
        val error = when {
            DayOfWeek.entries.find { it.value == input } == null -> Error.INVALID_INPUT
            else -> return
        }
        throw IllegalArgumentException(error.message)
    }
}