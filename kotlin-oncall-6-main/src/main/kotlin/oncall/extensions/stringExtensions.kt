package oncall.extensions

import oncall.model.Worker
import java.util.*

fun String.getMonth(): String {
    return this.split(",").first()
}

fun String.getDayOfWeek(): String {
    return this.split(",").last()
}

fun List<String>.isWorkersSizeInvalid(): Boolean {
    return size !in 5..35
}

fun List<String>.invalidWorkerNameLength(): Boolean {
    for (name in this) {
        if (name.length !in 1..5) {
            return true
        }
    }
    return false
}

fun List<String>.invalidWorkerRule(otherWorkers: List<String>): Boolean {
    for (name in this) {
        if (name !in otherWorkers) {
            return true
        }
    }
    return false
}

fun String.toWorkerQueue(): Queue<Worker> {
    val workers = this.split(",")
    val queue: Queue<Worker> = LinkedList()
    for (element in workers) {
        val worker = Worker(element)
        queue.add(worker)
    }
    return queue
}