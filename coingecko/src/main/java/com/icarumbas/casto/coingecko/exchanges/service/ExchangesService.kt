package com.icarumbas.casto.coingecko.exchanges.service

import com.icarumbas.casto.coingecko.coins.models.entities.CoinIdEntity
import com.icarumbas.casto.coingecko.exchanges.api.ExchangesApi
import com.icarumbas.casto.coingecko.exchanges.models.responses.CoinGeckoTickerResponse
import com.icarumbas.casto.coingecko.storage.CoinIdsRepository
import com.icarumbas.casto.coingecko.utils.PaginatedDataLoader
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


@Service
class ExchangesService(
    private val exchangesApi: ExchangesApi,
    private val coinIdsRepository: CoinIdsRepository,
) {

    private val logger = LoggerFactory.getLogger(ExchangesService::class.java)

    fun loadBinanceTickers() {
        val dataLoader = PaginatedDataLoader()
        val data = dataLoader.run { page ->
            requireNotNull(
                exchangesApi.getTickersForExchangeWithHeaders(BINANCE_ID, page))
        }
        val coinIds = data.flatMap { response ->
            response.tickers
        }.filter { ticker ->
            ticker.target == "USDT"
        }.map { resp ->
            resp.toCoinIdEntity()
        }
        coinIdsRepository.saveAll(coinIds)
    }

    private fun CoinGeckoTickerResponse.toCoinIdEntity() =
        CoinIdEntity(
            id = coinId,
            ticker = base,
        )

    companion object {
        private const val BINANCE_ID = "binance"
    }
}


