package oncall.model

import java.util.Queue

data class OncallWorker(
    val weekdayWorkers: Queue<Worker>,
    val weekendWorkers: Queue<Worker>
)