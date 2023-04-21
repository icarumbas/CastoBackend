package com.icarumbas.coingecko.coins.api.models.responses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoImageResponse(
    @SerialName("large")
    val large: String,
    @SerialName("small")
    val small: String,
    @SerialName("thumb")
    val thumb: String
)