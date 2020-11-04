package org.ideasoft.test

import org.ideasoft.test.domain.BidType
import org.ideasoft.test.queue.AQQueue
import org.ideasoft.test.queue.ZUQueue
import org.ideasoft.test.reader.BidsReader
import org.ideasoft.test.scheduler.Scheduler
import javax.management.timer.Timer.ONE_MINUTE

class Application {

    private val queues = mapOf(
        BidType.AQ to AQQueue(),
        BidType.ZU to ZUQueue()
    )

    private val scheduler = Scheduler()

    fun run() = scheduler.execute(ONE_MINUTE) {
        val bids = BidsReader().read()
        bids.forEach { bid ->
            queues.getValue(bid.type).log(bid)
        }
    }
}

fun main() {
    Application().run()
}