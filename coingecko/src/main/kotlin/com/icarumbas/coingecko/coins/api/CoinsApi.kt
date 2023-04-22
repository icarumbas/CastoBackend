package com.icarumbas.coingecko.coins.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate


@Component
class CoinsApi @Autowired constructor(
    @Qualifier("CoinGecko")
    private val restTemplate: RestTemplate
) {

    /**
     * Use this to obtain all the coins' id in order to make API calls
     * */
    fun getCoinsList(): Array<com.icarumbas.coingecko.coins.models.responses.CoinGeckoCoinIdItemResponse>? {
        val response = restTemplate.getForEntity("/coins/list",
            Array<com.icarumbas.coingecko.coins.models.responses.CoinGeckoCoinIdItemResponse>::class.java)
        return response.body
    }

    /**
     * Get current data (name, price, market, ... including exchange tickers) for a coin.
     * */
    fun getCoinById(id: String): com.icarumbas.coingecko.coins.models.responses.CoinGeckoCoinInfoResponse? {
        val response = restTemplate.getForEntity("/coins/$id", com.icarumbas.coingecko.coins.models.responses.CoinGeckoCoinInfoResponse::class.java)
        return response.body
    }
}