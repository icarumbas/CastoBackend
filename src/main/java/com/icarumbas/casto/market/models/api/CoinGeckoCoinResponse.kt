package com.icarumbas.casto.market.models.api

import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoCoinResponse(
    val id: String,
    val symbol: String
)