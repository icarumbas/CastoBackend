package com.icarumbas.casto.api.models

import kotlinx.serialization.Serializable

@Serializable
data class CoinIdMapCoinResponse(
    val id: Int,
    val name: String,
    val symbol: String,
)