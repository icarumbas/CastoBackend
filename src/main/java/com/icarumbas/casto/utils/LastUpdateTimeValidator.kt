package com.icarumbas.casto.utils

import org.springframework.stereotype.Component
import java.time.Instant

// sec
private const val UPDATE_VALID_PERIOD = 5 * 1000

@Component
class LastUpdateTimeValidator {

    fun isValid(timestamp: String): Boolean {
        val timestampTime = Instant.parse(timestamp).toEpochMilli()
        val currentTime = Instant.now().toEpochMilli()
        return currentTime - timestampTime < UPDATE_VALID_PERIOD
    }
}