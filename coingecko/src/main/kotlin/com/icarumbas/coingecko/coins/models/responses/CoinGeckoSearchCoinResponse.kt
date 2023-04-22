package com.icarumbas.coingecko.coins.models.responses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoSearchCoinResponse(
    @SerialName("coins")
    val coins: List<com.icarumbas.coingecko.coins.models.responses.CoinGeckoCoinResponse>
)