package com.icarumbas.casto.coingecko.exchanges.models.responses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoConvertedVolumeResponse(
    @SerialName("btc")
    val btc: Float,
    @SerialName("eth")
    val eth: Float,
    @SerialName("usd")
    val usd: Float
)