package oncall.global

enum class DayOfWeek(val value: String) {
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일");

    companion object {
        fun from(dayOfWeek: String): DayOfWeek {
            val replaced = dayOfWeek.replace("(휴일)", "")
            return entries.find { it.value == replaced }!!
        }

        fun isWeekday(dayOfWeek: String): Boolean {
            return dayOfWeek != SATURDAY.value && dayOfWeek != SUNDAY.value
        }

        fun nextDayOfWeek(dayOfWeek: String): DayOfWeek {
            val nextDayOfWeek = entries[(from(dayOfWeek).ordinal + 1) % 7]
            return nextDayOfWeek
        }
    }
}