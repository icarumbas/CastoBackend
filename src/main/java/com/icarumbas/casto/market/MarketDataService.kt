package com.icarumbas.casto.market

import com.icarumbas.casto.market.api.coins.CoinGeckoCoinIdsApi
import com.icarumbas.casto.market.models.coingecko.CoinGeckoCoinIdItemResponse
import com.icarumbas.casto.market.models.responses.MarketCoinInfoResponse
import com.icarumbas.casto.market.models.responses.MarketDataResponse
import com.icarumbas.casto.market.models.mappers.toCoinId
import com.icarumbas.casto.market.models.mappers.toPriceChangeResponse
import com.icarumbas.casto.market.models.requests.RequestCoinInfoItem
import com.icarumbas.casto.market.repository.CoinIdsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service
import java.lang.IllegalStateException

@Service
class MarketDataService @Autowired constructor(
    private val coinsApi: CoinGeckoCoinIdsApi,
    private val coinIdsRepository: CoinIdsRepository,
) {

    @EventListener
    fun preloadCoinIds(event: ApplicationReadyEvent) {
        if (coinIdsRepository.count() == 0L) {
            val allCoins = coinsApi.getCoinsList()
                ?: throw IllegalStateException("Couldn't preload coin ids")
            val storageCoins = allCoins.map(CoinGeckoCoinIdItemResponse::toCoinId)
            coinIdsRepository.saveAll(storageCoins)
        }
    }

    fun getCoins(coinInfoList: List<RequestCoinInfoItem>): MarketDataResponse {
        val marketCoinInfoResponseList = coinInfoList.mapNotNull { requestCoinInfoItem ->
            val coinId = findCoinIdForTicker(requestCoinInfoItem) ?: return@mapNotNull null
            val responseCoinData = coinsApi.getCoinById(coinId) ?: return@mapNotNull null
            val marketData = responseCoinData.marketData
            val priceChangeTimedResponse = marketData.toPriceChangeResponse()
            val price = marketData.currentPrice.usd

            MarketCoinInfoResponse(
                ticker = requestCoinInfoItem.ticker,
                name = requestCoinInfoItem.name.orEmpty(),
                price = price,
                holdingsPrice = requestCoinInfoItem.holdings * price,
                priceChangePercent = priceChangeTimedResponse
            )
        }

        return MarketDataResponse(marketCoinInfoResponseList)
    }

    private fun findCoinIdForTicker(coinInfo: RequestCoinInfoItem): String? {
        val coinIds = coinIdsRepository.getByTickerIgnoreCase(coinInfo.ticker)
        return when (coinIds.size) {
            0 -> null
            1 -> coinIds.first().id
            else -> {
                coinIds.find { it.name.equals(coinInfo.name, true) }?.id
            }
        }
    }
}