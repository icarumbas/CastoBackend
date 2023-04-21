package com.icarumbas.binance.api

import com.icarumbas.binance.models.BinanceUserAssetResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.net.URI

private const val BINANCE_BASE_URL = "https://api.binance.com"
private const val BINANCE_SAPI_ENDPOINT = "sapi/v3"
private const val BINANCE_API_ENDPOINT = "api/v3"

@Component
class BinanceApi @Autowired constructor(
    @Qualifier("binance")
    private val restTemplate: RestTemplate
) {

    fun getUserAssets(): Array<BinanceUserAssetResponse> {
        val uri = URI.create("$BINANCE_BASE_URL/$BINANCE_SAPI_ENDPOINT/asset/getUserAsset")
        val response = restTemplate.postForEntity(uri,
            null,
            Array<BinanceUserAssetResponse>::class.java)
        return response.body ?: emptyArray()
    }
}