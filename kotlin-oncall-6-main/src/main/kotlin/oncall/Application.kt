package oncall

import oncall.config.ApplicationFactory

fun main() {
    ApplicationFactory.createOnCallApplication().run()
}
