package com.icarumbas.casto.market.models.coingecko


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoSearchCoinResponse(
    @SerialName("coins")
    val coins: List<CoinGeckoCoinResponse>
)