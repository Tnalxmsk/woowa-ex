package oncall.view

class OutputView {
    fun printDailyWorker(month: Int, day: Int, dayOfWeek: String, name: String) {
        println("${month}월 ${day}일 $dayOfWeek $name")
    }
}