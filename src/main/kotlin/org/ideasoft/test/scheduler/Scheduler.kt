package org.ideasoft.test.scheduler

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class Scheduler {

    fun execute(delayInMillis: Long, action: () -> Unit) = runBlocking(Dispatchers.IO) {
        while(true) {
            action()
            delay(delayInMillis)
        }
    }
}