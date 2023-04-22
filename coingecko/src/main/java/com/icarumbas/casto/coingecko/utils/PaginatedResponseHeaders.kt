package com.icarumbas.casto.coingecko.utils

import com.icarumbas.casto.core.utils.safeLet
import org.springframework.http.ResponseEntity
import retrofit2.Response

data class PaginatedResponseHeaders(val total: Int, val perPage: Int) {

    companion object {
        fun extractFromResponse(response: Response<*>): PaginatedResponseHeaders? {
            val total = response.headers()["total"]?.toInt()
            val perPage = response.headers()["per-page"]?.toInt()
            return safeLet(total, perPage) { totalSafe, perPageSafe ->
                PaginatedResponseHeaders(totalSafe, perPageSafe)
            }
        }
    }
}