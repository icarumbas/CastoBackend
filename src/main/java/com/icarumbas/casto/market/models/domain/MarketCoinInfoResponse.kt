package com.icarumbas.casto.market.models.domain

import kotlinx.serialization.Serializable

@Serializable
data class MarketCoinInfoResponse(
    val ticker: String,
    val name: String,
    val price: Double,
    val priceChange: Double,
    val pricePrecision: Int,
)