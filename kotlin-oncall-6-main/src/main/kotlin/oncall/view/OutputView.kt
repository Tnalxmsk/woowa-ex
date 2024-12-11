package oncall.view

import oncall.global.DayOfWeek

class OutputView {
    fun printDailyWorker(month: Int, day: Int, dayOfWeek: String, name: String) {
        println("${month}월 ${day}일 $dayOfWeek $name")
    }
}