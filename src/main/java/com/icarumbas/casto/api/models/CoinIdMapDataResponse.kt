package com.icarumbas.casto.api.models

import kotlinx.serialization.Serializable

@Serializable
data class CoinIdMapDataResponse(
    val data: List<CoinIdMapCoinResponse>,

)