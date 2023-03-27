package com.icarumbas.casto.market.models.domain

import kotlinx.serialization.Serializable

@Serializable
data class MarketDataResponse(
    val data: List<MarketCoinInfoResponse>
)