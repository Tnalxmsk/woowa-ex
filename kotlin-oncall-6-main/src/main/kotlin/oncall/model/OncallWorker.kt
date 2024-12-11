package oncall.model

import java.util.Queue

data class OncallWorker(
    val weekdayWorkers: Queue<String>,
    val weekendWorkers: Queue<String>
)