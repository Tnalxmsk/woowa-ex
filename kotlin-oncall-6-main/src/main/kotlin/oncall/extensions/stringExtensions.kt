package oncall.extensions

fun String.getMonth(): String {
    return this.split(",").first()
}

fun String.getDayOfWeek(): String {
    return this.split(",").last()
}