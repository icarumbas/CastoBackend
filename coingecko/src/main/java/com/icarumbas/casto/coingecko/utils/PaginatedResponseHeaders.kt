package com.icarumbas.casto.coingecko.utils

import com.icarumbas.casto.core.utils.safeLet
import org.springframework.http.ResponseEntity

data class PaginatedResponseHeaders(val total: Int, val perPage: Int) {

    companion object {
        fun extractFromResponse(response: ResponseEntity<*>): PaginatedResponseHeaders? {
            val total = response.headers.getFirst("total")?.toInt()
            val perPage = response.headers.getFirst("perPage")?.toInt()
            return safeLet(total, perPage) { totalSafe, perPageSafe ->
                PaginatedResponseHeaders(totalSafe, perPageSafe)
            }
        }
    }
}