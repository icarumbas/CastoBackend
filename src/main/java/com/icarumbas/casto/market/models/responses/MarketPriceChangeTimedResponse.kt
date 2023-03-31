package com.icarumbas.casto.market.models.responses

import kotlinx.serialization.Serializable

@Serializable
data class MarketPriceChangeTimedResponse(
    val change1h: Float,
    val change24h: Float,
    val change7d: Float,
    val change14d: Float,
    val change30d: Float,
    val change60d: Float,
    val change1y: Float,
)