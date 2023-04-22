package com.icarumbas.coingecko.exchanges.models.responses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoMarketResponse(
    @SerialName("has_trading_incentive")
    val hasTradingIncentive: Boolean,
    @SerialName("identifier")
    val identifier: String,
    @SerialName("name")
    val name: String
)