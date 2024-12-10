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
            return entries.find { it.value == dayOfWeek }!!
        }

        fun isWeekday(dayOfWeek: String): Boolean {
            return dayOfWeek != SATURDAY.value && dayOfWeek != SUNDAY.value
        }
    }
}