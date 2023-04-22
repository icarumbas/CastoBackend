package com.icarumbas.coingecko.exchanges.service

import com.icarumbas.coingecko.exchanges.api.ExchangesApi
import com.icarumbas.coingecko.utils.PaginatedDataLoader
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


@Service
class ExchangesService(
    private val exchangesApi: ExchangesApi,
) {

    private val logger = LoggerFactory.getLogger(ExchangesService::class.java)

    fun loadBinanceTickers() {
        val dataLoader = PaginatedDataLoader()
        val data = dataLoader.run { page ->
            requireNotNull(
                exchangesApi.getTickersForExchangeWithHeaders(BINANCE_ID, page))
        }
        data.flatMap { response ->
            response.tickers
        }.filter { ticker ->
            ticker.target == "USDT"
        }
    }

    companion object {
        private const val BINANCE_ID = "binance"
    }
}


