package com.icarumbas.casto.market.models.requests

import kotlinx.serialization.Serializable

@Serializable
data class RequestCoinInfoItem(
    val ticker: String,
    val name: String? = null,
)