package com.icarumbas.casto.market.api.coins

import com.icarumbas.casto.market.models.coingecko.CoinGeckoCoinIdItemResponse
import com.icarumbas.casto.market.models.coingecko.CoinGeckoCoinInfoResponse
import com.icarumbas.casto.market.models.coingecko.CoinGeckoSearchCoinResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate


@Component
class CoinGeckoCoinIdsApi @Autowired constructor(
    @Qualifier("CoinGecko")
    private val restTemplate: RestTemplate
) {

    /**
     * Use this to obtain all the coins' id in order to make API calls
     * */
    fun getCoinsList(): Array<CoinGeckoCoinIdItemResponse>? {
        val response = restTemplate.getForEntity("/coins/list",
            Array<CoinGeckoCoinIdItemResponse>::class.java)
        return response.body
    }

    /**
     * Get current data (name, price, market, ... including exchange tickers) for a coin.
     * */
    fun getCoinById(id: String): CoinGeckoCoinInfoResponse? {
        val response = restTemplate.getForEntity("/coins/$id", CoinGeckoCoinInfoResponse::class.java)
        return response.body
    }

    fun search(query: String): CoinGeckoSearchCoinResponse? {
        val response = restTemplate.getForEntity(
            "/search?query={query}",
            CoinGeckoSearchCoinResponse::class.java,
            query
        )
        return response.body
    }
}