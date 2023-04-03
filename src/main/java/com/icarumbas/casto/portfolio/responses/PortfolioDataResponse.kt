package com.icarumbas.casto.portfolio.responses

import kotlinx.serialization.Serializable

@Serializable
data class PortfolioDataResponse(
    val coins: List<PortfolioCoinInfoResponse>
)