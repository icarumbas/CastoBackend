package com.icarumbas.casto.portfolio

import com.icarumbas.casto.binance.api.BinanceApi
import com.icarumbas.casto.market.api.coins.CoinGeckoCoinIdsApi
import com.icarumbas.casto.market.models.mappers.toPriceChangeResponse
import com.icarumbas.casto.market.models.responses.MarketCoinInfoResponse
import com.icarumbas.casto.market.models.responses.MarketDataResponse
import com.icarumbas.casto.market.repository.CoinIdsRepository
import com.icarumbas.casto.portfolio.mappers.toUserBinanceCredentials
import com.icarumbas.casto.portfolio.models.requests.BinanceCredentialsRequest
import com.icarumbas.casto.portfolio.repository.BinanceCredentialRepository
import com.icarumbas.casto.user.dependencies.RequestUserInfoHandler
import org.springframework.stereotype.Service
import java.lang.IllegalStateException
import java.util.UUID

@Service
class PortfolioService(
    private val binanceCredentialRepository: BinanceCredentialRepository,
    private val userInfoHandler: RequestUserInfoHandler,
    private val binanceApi: BinanceApi,
    private val coinIdsRepository: CoinIdsRepository,
    private val coinsApi: CoinGeckoCoinIdsApi,
) {

    fun saveBinanceCredentials(credentials: BinanceCredentialsRequest) {
        val uuid = userInfoHandler.getId()
        binanceCredentialRepository.save(credentials.toUserBinanceCredentials(uuid))
    }

    fun getPortfolio(): MarketDataResponse {
        val marketCoinInfoResponseList = binanceApi.getUserAssets().mapNotNull { asset ->
            val coinId = coinIdsRepository.getByTickerIgnoreCase(asset.asset).first().id
            val responseCoinData = coinsApi.getCoinById(coinId) ?: return@mapNotNull null
            val marketData = responseCoinData.marketData
            val priceChangeTimedResponse = marketData.toPriceChangeResponse()
            val price = marketData.currentPrice.usd

            MarketCoinInfoResponse(
                ticker = asset.asset,
                name = responseCoinData.name,
                price = price,
                holdingsPrice = asset.free * price,
                priceChangePercent = priceChangeTimedResponse
            )
        }

        return MarketDataResponse(marketCoinInfoResponseList)
    }
}