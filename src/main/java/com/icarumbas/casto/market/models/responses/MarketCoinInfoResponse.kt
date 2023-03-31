package com.icarumbas.casto.market.models.responses

import kotlinx.serialization.Serializable

@Serializable
data class MarketCoinInfoResponse(
    val ticker: String,
    val name: String,
    val price: Float,
    val holdingsPrice: Float,
    val priceChangePercent: MarketPriceChangeTimedResponse,
)