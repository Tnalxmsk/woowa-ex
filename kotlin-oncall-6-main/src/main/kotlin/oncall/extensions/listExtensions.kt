package oncall.extensions

import java.util.*

fun <T> List<T>.toQueue(): Queue<T> {
    val queue: Queue<T> = LinkedList()
    for (element in this) {
        queue.add(element)
    }
    return LinkedList(this)
}