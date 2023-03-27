package com.icarumbas.casto.market

import com.icarumbas.casto.market.responses.MarketDataResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MarketDataService @Autowired constructor(
    private val marketDataApi: MarketDataApi
) {

    fun getCoins(tickers: List<String>, currency: String? = "usd"): MarketDataResponse {

    }
}