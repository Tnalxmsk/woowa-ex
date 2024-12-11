package oncall.model

import oncall.global.DayOfWeek

class DailyWorker(
    private val date: Date,
    private var worker: Worker,
) {

    fun day() = date.day

    fun dayOfWeek() = date.dayOfWeek

    fun workerName() = worker.name

    fun changeWorker(prevDailyWorker: DailyWorker, nextDailyWorker: DailyWorker) {
        if (!isContinuousWork(prevDailyWorker.workerName())) return
        val nextDayOfWeek = DayOfWeek.nextDayOfWeek(date.dayOfWeek)
        if (!DayOfWeek.isWeekday(date.dayOfWeek) && !DayOfWeek.isWeekday(nextDayOfWeek.value)) {
            val nowWorker = worker
            setWorker(nextDailyWorker.worker)
            nextDailyWorker.setWorker(nowWorker)
            return
        }
        if (DayOfWeek.isWeekday(date.dayOfWeek) && DayOfWeek.isWeekday(nextDayOfWeek.value)) {
            val nowWorker = worker
            setWorker(nextDailyWorker.worker)
            nextDailyWorker.setWorker(nowWorker)
            return
        }
    }

    private fun isContinuousWork(before: String): Boolean {
        return worker.name == before
    }

    private fun setWorker(worker: Worker) {
        this.worker = worker
    }
}
