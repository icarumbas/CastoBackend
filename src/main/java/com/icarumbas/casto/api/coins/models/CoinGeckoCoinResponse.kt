package com.icarumbas.casto.api.coins.models

import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoCoinResponse(
    val id: String,
    val symbol: String
)