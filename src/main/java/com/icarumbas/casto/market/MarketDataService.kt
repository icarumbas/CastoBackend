package com.icarumbas.casto.market

import com.icarumbas.casto.market.api.coins.CoinGeckoCoinIdsApi
import com.icarumbas.casto.market.models.coingecko.CoinGeckoCoinIdItemResponse
import com.icarumbas.casto.market.models.domain.MarketCoinInfoResponse
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

    fun getCoinIds() {
        val allCoins = coinsApi.getCoinsList()!!
        val storageCoins = allCoins.map(CoinGeckoCoinIdItemResponse::toCoinId)
        coinIdsRepository.saveAll(storageCoins)
    }

    fun getCoins(tickers: List<String>, currency: String? = "usd"): MarketDataResponse {
        val marketCoinInfoResponseList = tickers.mapNotNull { ticker ->
            val coinIds = coinIdsRepository.getByTickerIgnoreCase(ticker)
            val coinId = when (coinIds.size) {
                0 -> null
                1 -> coinIds.first()
                else -> {
                    coinIds.first {
                        it.id.equals(ticker, true)
                    }
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