package oncall.util

import oncall.extensions.toWorkerQueue
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat


class DailyWorkerGeneratorTest {

    @Test
    fun `공휴일과 연속 근무를 고려하지 않은 근무표를 생성한다`() {
        val weekdayEmployee = "준팍,도밥,고니,수아,루루,글로,솔로스타,우코,슬링키,참새,도리".toWorkerQueue()
        val weekendEmployee = "수아,루루,글로,솔로스타,우코,슬링키,참새,도리,준팍,도밥,고니".toWorkerQueue()
        val days = CalendarGenerator.generateCalendar(5, "월")

        val result = ScheduleGenerator.generateBeforeSchedule(weekdayEmployee, weekendEmployee, 5, days)
        val expect = listOf(
            "준팍", "도밥", "고니", "수아", "수아", "루루", "글로",
            "루루", "글로", "솔로스타", "우코", "슬링키", "솔로스타", "우코",
            "참새", "도리", "준팍", "도밥", "고니", "슬링키", "참새",
            "수아", "루루", "글로", "솔로스타", "우코", "도리", "준팍",
            "슬링키", "참새", "도리")
        for (index in result.indices) {
            assertThat(result[index].workerName()).isEqualTo(expect[index])
        }
        val nextResult = ScheduleGenerator.generateAfterSchedule(result)
        val nextExpect = listOf(
            "준팍", "도밥", "고니", "수아", "루루", "수아", "글로",
            "루루", "글로", "솔로스타", "우코", "슬링키", "솔로스타", "우코",
            "참새", "도리", "준팍", "도밥", "고니", "슬링키", "참새",
            "수아", "루루", "글로", "솔로스타", "우코", "도리", "준팍",
            "슬링키", "참새", "도리")

        for (index in nextResult.indices) {
            assertThat(nextResult[index].workerName()).isEqualTo(nextExpect[index])
        }
    }
}