package com.icarumbas.casto.market.models.requests

import kotlinx.serialization.Serializable

@Serializable
data class RequestCoinInfoData(
    val data: List<RequestCoinInfoItem>
)