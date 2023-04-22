package com.icarumbas.casto.coingecko.exchanges.api


import com.icarumbas.casto.coingecko.exchanges.models.responses.CoinGeckoExchangeTickersResponse
import com.icarumbas.casto.coingecko.utils.PaginatedResponseHeaders
import com.icarumbas.casto.coingecko.utils.PaginatedResponseWrapper
import com.icarumbas.casto.core.utils.safeLet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate


@Component
class ExchangesApi @Autowired constructor(
    @Qualifier("CoinGecko")
    private val restTemplate: RestTemplate
) {

    /**
     * Get exchange tickers (paginated)
     *
     * IMPORTANT:
     * Ticker is_stale is true when ticker that has not been updated/unchanged
     * from the exchange for a while.
     * Ticker is_anomaly is true if ticker's price is outliered by our system.
     * You are responsible for managing how you want to display these information
     * (e.g. footnote, different background, change opacity, hide)
     * */
    fun getTickersForExchangeWithHeaders(
        exchange: String,
        page: Int
    ): PaginatedResponseWrapper<CoinGeckoExchangeTickersResponse>? {
        val responseRaw = getTickersForExchangeResponse(exchange, page)
        val response = responseRaw.body
        val headers = PaginatedResponseHeaders.extractFromResponse(responseRaw)
        return safeLet(response, headers) { safeResponse, safeHeaders ->
            PaginatedResponseWrapper(safeResponse, safeHeaders)
        }
    }

    fun getTickersForExchange(exchange: String, page: Int): CoinGeckoExchangeTickersResponse? {
        return getTickersForExchangeResponse(exchange, page).body
    }

    private fun getTickersForExchangeResponse(
        exchange: String,
        page: Int
    ): ResponseEntity<CoinGeckoExchangeTickersResponse> {
        val variables = mapOf("page" to page)
        return restTemplate.getForEntity(
            "exchanges/$exchange/tickers",
            CoinGeckoExchangeTickersResponse::class.java, variables
        )
    }
}