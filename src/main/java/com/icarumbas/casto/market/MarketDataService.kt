package com.icarumbas.casto.market

import com.icarumbas.casto.market.api.coins.CoinGeckoCoinIdsApi
import com.icarumbas.casto.market.models.coingecko.CoinGeckoCoinIdItemResponse
import com.icarumbas.casto.market.models.coingecko.CoinGeckoCoinIdResponse
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

    fun getCoinIds(): CoinGeckoCoinIdResponse {
        val allCoins = coinsApi.getCoinsList()
        val storageCoins = allCoins.map(CoinGeckoCoinIdItemResponse::toCoinId)
        coinIdsRepository.saveAll(storageCoins)
        return allCoins
    }

    fun getCoins(tickers: List<String>, currency: String? = "usd"): MarketDataResponse {
        val marketCoinInfoResponseList = tickers.map { ticker ->
            val coinId = coinIdsRepository.getByTickerIgnoreCase(ticker).coinGeckoId
            val coinInfo = coinsApi.getCoinById(coinId)
            MarketCoinInfoResponse(
                ticker = ticker,
                name = coinInfo.name,
                price = coinInfo.marketData.currentPrice.usd!!,
                priceChange = coinInfo.marketData.priceChangePercentage24hInCurrency.usd!!
            )
        }

        return MarketDataResponse(marketCoinInfoResponseList)
    }
}