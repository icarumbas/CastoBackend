package com.icarumbas.casto.market.models.coingecko


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoReposUrlResponse(
    @SerialName("bitbucket")
    val bitbucket: List<String>,
    @SerialName("github")
    val github: List<String>
)