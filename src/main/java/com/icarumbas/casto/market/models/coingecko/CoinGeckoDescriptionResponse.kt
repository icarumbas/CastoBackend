package com.icarumbas.casto.market.models.coingecko


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoDescriptionResponse(
    @SerialName("en")
    val en: String
)