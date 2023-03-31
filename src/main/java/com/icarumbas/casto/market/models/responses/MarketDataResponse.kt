package com.icarumbas.casto.market.models.responses

import kotlinx.serialization.Serializable

@Serializable
data class MarketDataResponse(
    val data: List<MarketCoinInfoResponse>
)