package com.icarumbas.casto.market.responses

import kotlinx.serialization.Serializable

@Serializable
data class MarketDataResponse(
    val data: List<MarketCoinInfoResponse>
)