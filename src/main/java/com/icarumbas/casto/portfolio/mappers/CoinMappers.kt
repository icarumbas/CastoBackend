package com.icarumbas.casto.portfolio.mappers

import com.icarumbas.casto.market.models.storage.CoinPriceEntity
import com.icarumbas.casto.portfolio.responses.PortfolioCoinIPriceChangeResponse

fun CoinPriceEntity.toPortfolioCoinIPriceChangeResponse() =
    PortfolioCoinIPriceChangeResponse(
        changePercent1h,
        changePercent24h,
        changePercent7d,
        changePercent14d,
        changePercent30d,
        changePercent60d,
        changePercent1y
    )