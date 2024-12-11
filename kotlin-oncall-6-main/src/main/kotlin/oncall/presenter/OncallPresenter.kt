package oncall.presenter

import oncall.model.DailyWorker
import oncall.model.OncallDate
import oncall.model.OncallWorker
import oncall.util.ScheduleGenerator

class OncallPresenter {

    fun createBeforeSchedule(
        oncallDate: OncallDate,
        oncallWorker: OncallWorker,
    ): MutableList<DailyWorker> {
        val beforeSchedule =
            ScheduleGenerator.generateBeforeSchedule(
                oncallWorker.weekdayWorkers,
                oncallWorker.weekendWorkers,
                oncallDate.getMonth(),
                oncallDate.getCalendar()
            )
        return beforeSchedule
    }

    fun createAfterSchedule(
        beforeSchedule: MutableList<DailyWorker>
    ): MutableList<DailyWorker> {
        val afterSchedule = ScheduleGenerator.generateAfterSchedule(beforeSchedule)
        return afterSchedule
    }
}