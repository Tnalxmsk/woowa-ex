package oncall.util

import org.junit.jupiter.api.Test
import java.util.*
import org.assertj.core.api.Assertions.assertThat


class ScheduleGeneratorTest {

    @Test
    fun `공휴일과 연속 근무를 고려하지 않은 근무표를 생성한다`() {
        val a = listOf("준팍", "도밥", "고니", "수아", "루루", "글로", "솔로스타", "우코", "슬링키", "참새", "도리")
        val b = listOf("수아", "루루", "글로", "솔로스타", "우코", "슬링키", "참새", "도리", "준팍", "도밥", "고니")
        val weekdayEmployee: Queue<String> = LinkedList()
        val weekendEmployee: Queue<String> = LinkedList()
        val days = CalendarGenerator.generateCalendar(5, "월")
        a.forEach {
            weekdayEmployee.add(it)
        }
        b.forEach {
            weekendEmployee.add(it)
        }
        val result = ScheduleGenerator.generateBeforeSchedule(weekdayEmployee, weekendEmployee, days)
        val expect = listOf(
            "준팍", "도밥", "고니", "수아", "루루", "수아", "루루",
            "글로", "솔로스타", "우코", "슬링키", "참새", "글로", "솔로스타",
            "도리", "준팍", "도밥", "고니", "수아", "우코", "슬링키",
            "루루", "글로", "솔로스타", "우코", "슬링키", "참새", "도리",
            "참새", "도리", "준팍")
        assertThat(result).isEqualTo(expect)
    }
}