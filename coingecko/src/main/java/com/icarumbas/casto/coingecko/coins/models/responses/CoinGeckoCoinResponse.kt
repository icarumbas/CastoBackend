package com.icarumbas.casto.coingecko.coins.models.responses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoCoinResponse(
    @SerialName("api_symbol")
    val apiSymbol: String?,
    @SerialName("id")
    val id: String,
    @SerialName("large")
    val large: String,
    @SerialName("market_cap_rank")
    val marketCapRank: Long?,
    @SerialName("name")
    val name: String,
    @SerialName("symbol")
    val symbol: String,
    @SerialName("thumb")
    val thumb: String
)