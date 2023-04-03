package com.icarumbas.casto.market

import com.icarumbas.casto.market.api.coins.CoinGeckoCoinIdsApi
import com.icarumbas.casto.market.models.mappers.toCoinId
import com.icarumbas.casto.market.models.mappers.toCoinPriceEntity
import com.icarumbas.casto.market.models.storage.CoinIdEntity
import com.icarumbas.casto.market.models.storage.CoinPriceEntity
import com.icarumbas.casto.market.repository.CoinIdsRepository
import com.icarumbas.casto.market.repository.CoinPricesRepository
import com.icarumbas.casto.utils.LastUpdateTimeValidator
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service

@Service
class MarketDataService @Autowired constructor(
    private val coinsApi: CoinGeckoCoinIdsApi,
    private val coinIdsRepository: CoinIdsRepository,
    private val coinPricesRepository: CoinPricesRepository,
    private val lastUpdateTimeValidator: LastUpdateTimeValidator,
) {

    fun getCoinMarketId(symbol: String): CoinIdEntity? {
        return try {
            coinIdsRepository.getByTickerIgnoreCase(symbol)
        } catch (e: EmptyResultDataAccessException) {
            val coin = coinsApi.search(symbol)?.coins?.firstOrNull() ?: return null
            val localCoinIdData = coin.toCoinId()
            coinIdsRepository.save(localCoinIdData)
        }
    }

    fun getCoinPriceBySymbol(symbol: String): CoinPriceEntity? {
        val coinGeckoCoinId = getCoinMarketId(symbol)?.id ?: return null
        return getCoinPriceById(coinGeckoCoinId)
    }

    fun getCoinPriceById(id: String): CoinPriceEntity? {
        return if (coinPricesRepository.existsById(id)) {
            val coinPrice = coinPricesRepository.getReferenceById(id)
            if (lastUpdateTimeValidator.isValid(coinPrice.lastUpdated)) {
                coinPrice
            } else {
                loadCoinPrice(id)
            }
        } else {
            loadCoinPrice(id)
        }
    }

    private fun loadCoinPrice(id: String): CoinPriceEntity? {
        val responseCoinData = coinsApi.getCoinById(id) ?: return null
        val coinPriceEntity = responseCoinData.marketData.toCoinPriceEntity(id)
        return coinPricesRepository.save(coinPriceEntity)
    }
}