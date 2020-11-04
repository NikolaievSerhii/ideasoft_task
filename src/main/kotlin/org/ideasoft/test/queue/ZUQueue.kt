package org.ideasoft.test.queue

import mu.KLogger
import mu.KotlinLogging

class ZUQueue : Queue {
    override val logger: KLogger = KotlinLogging.logger {}
}