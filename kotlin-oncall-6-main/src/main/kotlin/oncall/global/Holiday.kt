package oncall.global

enum class Holiday(val month: Int, val day: Int) {
    NEW_YEAR(1,1),
    INDEPENDENCE_MOVEMENT_DAY(3,1),
    CHILDREN_DAY(5,5),
    MEMORIAL_DAY(6,6),
    LIBERATION_DAY(8,15),
    NATIONAL_FOUNDATION_DAY(10,3),
    HANGUL_DAY(10,9),
    CHRISTMAS(12,25);

    companion object {
        fun from(month: Int, day: Int): Holiday {
            return entries.find { it.month == month && it.day == day }!!
        }
    }
}