package com.icarumbas.coingecko.coins.api.models.responses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoDescriptionResponse(
    @SerialName("en")
    val en: String
)