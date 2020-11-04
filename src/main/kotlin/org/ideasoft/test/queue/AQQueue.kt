package org.ideasoft.test.queue

import mu.KLogger
import mu.KotlinLogging

class AQQueue : Queue {
    override val logger: KLogger = KotlinLogging.logger {}
}