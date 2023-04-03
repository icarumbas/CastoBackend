package com.icarumbas.casto.market.models.mappers

import com.icarumbas.casto.market.models.coingecko.CoinGeckoMarketDataResponse
import com.icarumbas.casto.market.models.storage.CoinPriceEntity

fun CoinGeckoMarketDataResponse.toCoinPriceEntity(
    id: String,
): CoinPriceEntity {

    return CoinPriceEntity(
        id = id,
        price = currentPrice.usd,
        lastUpdated = lastUpdated,
        changePercent1h = priceChangePercentage1hInCurrency.usd,
        changePercent24h = priceChangePercentage24hInCurrency.usd,
        changePercent7d = priceChangePercentage7dInCurrency.usd,
        changePercent14d = priceChangePercentage14dInCurrency.usd,
        changePercent30d = priceChangePercentage30dInCurrency.usd,
        changePercent60d = priceChangePercentage60dInCurrency.usd,
        changePercent1y = priceChangePercentage1yInCurrency.usd,
    )
}