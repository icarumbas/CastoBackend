package com.icarumbas.casto.portfolio

import com.icarumbas.casto.binance.api.BinanceApi
import com.icarumbas.casto.market.MarketDataService
import com.icarumbas.casto.market.api.coins.CoinGeckoCoinIdsApi
import com.icarumbas.casto.market.repository.CoinIdsRepository
import com.icarumbas.casto.portfolio.mappers.toPortfolioCoinIPriceChangeResponse
import com.icarumbas.casto.portfolio.mappers.toUserBinanceCredentials
import com.icarumbas.casto.portfolio.models.requests.BinanceCredentialsRequest
import com.icarumbas.casto.portfolio.repository.BinanceCredentialRepository
import com.icarumbas.casto.portfolio.responses.PortfolioCoinInfoResponse
import com.icarumbas.casto.portfolio.responses.PortfolioDataResponse
import com.icarumbas.casto.user.dependencies.RequestUserInfoHandler
import org.springframework.stereotype.Service

@Service
class PortfolioService(
    private val binanceCredentialRepository: BinanceCredentialRepository,
    private val userInfoHandler: RequestUserInfoHandler,
    private val binanceApi: BinanceApi,
    private val marketDataService: MarketDataService,
) {

    fun saveBinanceCredentials(credentials: BinanceCredentialsRequest) {
        val uuid = userInfoHandler.getId()
        binanceCredentialRepository.save(credentials.toUserBinanceCredentials(uuid))
    }

    fun getPortfolio(): PortfolioDataResponse {
        val coinsResponse = binanceApi.getUserAssets().mapNotNull { asset ->
            val coinId = marketDataService.getCoinMarketId(asset.asset)
                ?: return@mapNotNull null
            val coinPrice = marketDataService.getCoinPriceById(coinId.id)
                ?: return@mapNotNull null

            PortfolioCoinInfoResponse(
                id = coinId.id,
                ticker = asset.asset,
                name = coinId.name,
                price = coinPrice.price,
                holdingsPrice = asset.free * coinPrice.price,
                priceChangePercent = coinPrice.toPortfolioCoinIPriceChangeResponse()
            )
        }

        return PortfolioDataResponse(coinsResponse)
    }
}