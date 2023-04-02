package com.icarumbas.casto.portfolio.models.requests

import kotlinx.serialization.Serializable

@Serializable
data class BinanceCredentialsRequest(
    val publicKey: String,
    val privateKey: String,
)