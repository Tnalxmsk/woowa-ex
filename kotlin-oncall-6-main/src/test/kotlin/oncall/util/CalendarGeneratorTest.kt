package oncall.util

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class CalendarGeneratorTest {

    @Test
    fun `달력을 생성한다`() {
        val month = 4
        val startDayOfWeek = "화"
        val days = CalendarGenerator.generateCalendar(month, startDayOfWeek)

        val expected = listOf(
            "화", "수", "목", "금", "토", "일", "월",
            "화", "수", "목", "금", "토", "일", "월",
            "화", "수", "목", "금", "토", "일", "월",
            "화", "수", "목", "금", "토", "일", "월",
            "화", "수"
        )

        assertThat(days).isEqualTo(expected)
    }
}