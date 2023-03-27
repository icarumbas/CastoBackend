package com.icarumbas.casto.market

import com.icarumbas.casto.market.api.coins.CoinGeckoCoinIdsApi
import com.icarumbas.casto.market.models.api.CoinGeckoCoinResponse
import com.icarumbas.casto.market.models.domain.MarketDataResponse
import com.icarumbas.casto.market.models.mappers.toCoinId
import com.icarumbas.casto.market.repository.CoinIdsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MarketDataService @Autowired constructor(
    private val coinsApi: CoinGeckoCoinIdsApi,
    private val coinIdsRepository: CoinIdsRepository,
) {

    fun prepare() {
        val allCoins = coinsApi.getCoinsList()
        val storageCoins = allCoins.map(CoinGeckoCoinResponse::toCoinId)
        coinIdsRepository.saveAll(storageCoins)
    }

    fun getCoins(tickers: List<String>, currency: String? = "usd"): MarketDataResponse {

    }
}