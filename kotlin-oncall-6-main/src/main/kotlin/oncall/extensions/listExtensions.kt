package oncall.extensions

import oncall.model.Worker
import java.util.*

fun List<String>.toWorkerQueue(): Queue<Worker> {
    val queue: Queue<Worker> = LinkedList()
    for (element in this) {
        val worker = Worker(element)
        queue.add(worker)
    }
    return queue
}