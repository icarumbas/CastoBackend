package com.icarumbas.coingecko.coins.api.models.responses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoReposUrlResponse(
    @SerialName("bitbucket")
    val bitbucket: List<String>,
    @SerialName("github")
    val github: List<String>
)