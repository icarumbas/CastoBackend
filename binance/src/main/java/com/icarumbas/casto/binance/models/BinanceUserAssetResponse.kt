package com.icarumbas.casto.binance.models

import kotlinx.serialization.Serializable

@Serializable
data class BinanceUserAssetResponse(
    val asset: String,
    val free: Float,
    val locked: Float,
    val freeze: Float,
    val withdrawing: Float,
    val ipoable: Float,
    val btcValuation: Float? = null,
)