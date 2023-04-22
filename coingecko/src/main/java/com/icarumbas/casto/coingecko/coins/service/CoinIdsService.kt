/*
package com.icarumbas.casto.coingecko.coins.service

import com.icarumbas.casto.coingecko.coins.models.entities.CoinIdEntity
import com.icarumbas.casto.coingecko.coins.models.responses.CoinGeckoCoinIdItemResponse
import com.icarumbas.casto.coingecko.storage.CoinIdsRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CoinIdsService(
    private val coinsApi: CoinsApi,
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
        return CoinIdEntity(id, symbol)
    }
}*/
