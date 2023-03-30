package com.icarumbas.casto.market.api.coins

import com.icarumbas.casto.market.models.coingecko.CoinGeckoCoinIdResponse
import com.icarumbas.casto.market.models.coingecko.CoinGeckoCoinInfoResponse
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
    fun getCoinsList(): CoinGeckoCoinIdResponse? {
        val response = restTemplate.getForEntity("/coins/list", CoinGeckoCoinIdResponse::class.java)
        return response.body
    }

    /**
     * Get current data (name, price, market, ... including exchange tickers) for a coin.
     * */
    fun getCoinById(id: String): CoinGeckoCoinInfoResponse? {
        val response = restTemplate.getForEntity("/coins/$id", CoinGeckoCoinInfoResponse::class.java)
        return response.body
    }
}