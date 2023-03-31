package com.icarumbas.casto.market

import com.icarumbas.casto.market.api.coins.CoinGeckoCoinIdsApi
import com.icarumbas.casto.market.models.coingecko.CoinGeckoCoinIdItemResponse
import com.icarumbas.casto.market.models.domain.MarketCoinInfoResponse
import com.icarumbas.casto.market.models.domain.MarketDataResponse
import com.icarumbas.casto.market.models.mappers.toCoinId
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

    fun getCoins(coinInfoList: List<RequestCoinInfoItem>, currency: String? = "usd"): MarketDataResponse {
        val marketCoinInfoResponseList = coinInfoList.mapNotNull { coinInfo ->
            val ticker = coinInfo.ticker
            val coinIds = coinIdsRepository.getByTickerIgnoreCase(ticker)
            val coinId = when (coinIds.size) {
                0 -> null
                1 -> coinIds.first()
                else -> {
                    coinIds.find { it.name.equals(coinInfo.name, true) }
                }
            } ?: return@mapNotNull null

            val coinInfo = coinsApi.getCoinById(coinId.id) ?: return@mapNotNull null
            MarketCoinInfoResponse(
                ticker = ticker,
                name = coinInfo.name,
                price = coinInfo.marketData.currentPrice.usd,
                priceChange = coinInfo.marketData.priceChangePercentage24hInCurrency.usd
            )
        }

        return MarketDataResponse(marketCoinInfoResponseList)
    }
}