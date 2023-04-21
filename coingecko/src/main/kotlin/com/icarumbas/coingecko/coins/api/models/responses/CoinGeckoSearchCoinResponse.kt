package com.icarumbas.coingecko.coins.api.models.responses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoSearchCoinResponse(
    @SerialName("coins")
    val coins: List<CoinGeckoCoinResponse>
)