package org.ideasoft.test

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.ideasoft.test.domain.BidType
import org.ideasoft.test.queue.AQQueue
import org.ideasoft.test.queue.ZUQueue
import org.ideasoft.test.reader.BidsReader
import javax.management.timer.Timer.ONE_MINUTE

class Application {

    private val queues = mapOf(
        BidType.AQ to AQQueue(),
        BidType.ZU to ZUQueue()
    )

    fun run() = runBlocking(Dispatchers.IO) {
        while (true) {
            val bids = BidsReader().read()
            bids.forEach { bid ->
                queues.getValue(bid.type).log(bid)
            }
            delay(ONE_MINUTE)
        }
    }
}

fun main() {
    Application().run()
}