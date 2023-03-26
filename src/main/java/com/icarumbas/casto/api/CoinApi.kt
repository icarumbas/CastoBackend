package com.icarumbas.casto.api

import com.icarumbas.casto.api.models.CoinIdMapDataResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.client.RestTemplate


class CoinApi @Autowired constructor(
    @Qualifier("coinApi")
    private val restTemplate: RestTemplate
): MarketDataApi {

    override fun getCoinIdMap(): CoinIdMapDataResponse {
        val response = restTemplate.getForEntity(
            "/v1/cryptocurrency/map", CoinIdMapDataResponse::class.java)
        return response.body
    }
}