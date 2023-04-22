package com.icarumbas.casto.coingecko.exchanges.models.responses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoExchangeTickersResponse(
    @SerialName("name")
    val name: String,
    @SerialName("tickers")
    val tickers: List<CoinGeckoTickerResponse>
)