package com.icarumbas.casto.market.models.mappers

import com.icarumbas.casto.market.models.coingecko.CoinGeckoMarketDataResponse
import com.icarumbas.casto.market.models.responses.MarketPriceChangeTimedResponse

fun CoinGeckoMarketDataResponse.toPriceChangeResponse(): MarketPriceChangeTimedResponse {
    return MarketPriceChangeTimedResponse(
        change1h = priceChangePercentage1hInCurrency.usd,
        change24h = priceChangePercentage24h,
        change7d = priceChangePercentage7d,
        change14d = priceChangePercentage14d,
        change30d = priceChangePercentage30d,
        change60d = priceChangePercentage60d,
        change1y = priceChangePercentage1y
    )
}