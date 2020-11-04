package org.ideasoft.test.queue

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mu.KLogger
import org.ideasoft.test.domain.Bid
import java.nio.charset.StandardCharsets
import java.util.Base64

interface Queue {
    val logger: KLogger
    fun log(bid: Bid) = runBlocking(Dispatchers.IO) {
        launch {
            logger.info { "id: ${bid.id}; timestamp: ${bid.timestamp}, queue name: ${bid.type}, payload: ${bid.payload.decode()}" }
        }
    }

    private fun String.decode(): String {
        val encodedBytes = this.toByteArray(StandardCharsets.UTF_8)
        return String(Base64.getDecoder().decode(encodedBytes), StandardCharsets.UTF_8)
    }
}