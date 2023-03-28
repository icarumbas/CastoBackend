package com.icarumbas.casto.market.models.domain

import kotlinx.serialization.Serializable

@Serializable
data class MarketCoinInfoResponse(
    val ticker: String,
    val name: String,
    val price: Float,
    val priceChange: Float
)