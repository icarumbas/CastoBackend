package com.icarumbas.coingecko.utils

import java.util.concurrent.Callable
import java.util.concurrent.Executors

class PaginatedDataLoader {

    private val executorService = Executors.newCachedThreadPool()

    fun<T> run(pagedCall: (Int) -> PaginatedResponseWrapper<T>): List<T> {
        val responseWithHeaders = pagedCall(1)
        val pagedInfo = responseWithHeaders.pagedInfo
        val reqCount = pagedInfo.total / pagedInfo.perPage - 1
        val callables = List(reqCount) { index ->
            Callable {
                pagedCall(2 + index).response 
            }
        }
        val features = executorService.invokeAll(callables)
        return listOf(responseWithHeaders.response) + features.map { feature -> 
            feature.get()
        }
    }
}