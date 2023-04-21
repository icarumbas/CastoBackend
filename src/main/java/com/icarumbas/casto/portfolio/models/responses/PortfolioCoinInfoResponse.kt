package com.icarumbas.casto.portfolio.models.responses

import kotlinx.serialization.Serializable

@Serializable
data class PortfolioCoinInfoResponse(
    val id: String,
    val symbol: String,
    val name: String,
    val price: Float,
    val holdings: Float,
    val priceChangePercent: PortfolioCoinIPriceChangeResponse,
)