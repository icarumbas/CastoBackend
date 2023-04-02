package com.icarumbas.casto.binance.api

import com.icarumbas.casto.binance.models.BinanceUserAssetResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class BinanceApi @Autowired constructor(
    @Qualifier("binance-api")
    private val apiRestTemplate: RestTemplate,
    @Qualifier("binance-sapi")
    private val sapiRestTemplate: RestTemplate
) {

    fun getUserAssets(): Array<BinanceUserAssetResponse> {
        val response = sapiRestTemplate.getForEntity("asset/getUserAsset",
            Array<BinanceUserAssetResponse>::class.java)
        return response.body ?: emptyArray()
    }
}