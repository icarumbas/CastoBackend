package com.icarumbas.coingecko.coins.service

import com.icarumbas.coingecko.coins.api.CoinGeckoCoinsApi
import com.icarumbas.coingecko.coins.api.models.responses.CoinGeckoCoinIdItemResponse
import com.icarumbas.coingecko.coins.storage.CoinIdsRepository
import com.icarumbas.coingecko.coins.storage.models.CoinIdEntity
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CoinIdsService(
    private val coinsApi: CoinGeckoCoinsApi,
    private val coinIdsRepository: CoinIdsRepository,
) {

    private val logger = LoggerFactory.getLogger(CoinIdsService::class.java)

    fun loadCoinIdsList() {
        if (coinIdsRepository.isEmpty()) {
            val coinIds = coinsApi.getCoinsList()
            val coinIdResponses = requireNotNull(coinIds)
            val entities = coinIdResponses.map { it.toCoinIdEntity() }
            coinIdsRepository.saveAll(entities)
        }
    }

    private fun CoinIdsRepository.isEmpty() = count() == 0L

    private fun CoinGeckoCoinIdItemResponse.toCoinIdEntity(): CoinIdEntity {
        return CoinIdEntity(id, symbol, name)
    }
}