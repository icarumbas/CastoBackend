package com.icarumbas.casto.coingecko.coins.models.responses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoMarketDataResponse(
    @SerialName("ath")
    val ath: com.icarumbas.coingecko.coins.models.responses.CoinGeckoAthResponse,
    @SerialName("ath_change_percentage")
    val athChangePercentage: com.icarumbas.coingecko.coins.models.responses.CoinGeckoAthChangePercentageResponse,
    @SerialName("ath_date")
    val athDate: com.icarumbas.coingecko.coins.models.responses.CoinGeckoAthDateResponse,
    @SerialName("atl")
    val atl: com.icarumbas.coingecko.coins.models.responses.CoinGeckoAtlResponse,
    @SerialName("atl_change_percentage")
    val atlChangePercentage: com.icarumbas.coingecko.coins.models.responses.CoinGeckoAtlChangePercentageResponse,
    @SerialName("atl_date")
    val atlDate: com.icarumbas.coingecko.coins.models.responses.CoinGeckoAtlDateResponse,
    @SerialName("circulating_supply")
    val circulatingSupply: Float?,
    @SerialName("current_price")
    val currentPrice: com.icarumbas.coingecko.coins.models.responses.CoinGeckoCurrentPriceResponse,
    @SerialName("high_24h")
    val high24h: com.icarumbas.coingecko.coins.models.responses.CoinGeckoHigh24hResponse,
    @SerialName("last_updated")
    val lastUpdated: String,
    @SerialName("low_24h")
    val low24h: com.icarumbas.coingecko.coins.models.responses.CoinGeckoLow24hResponse,
    @SerialName("market_cap")
    val marketCap: com.icarumbas.coingecko.coins.models.responses.CoinGeckoMarketCapResponse,
    @SerialName("market_cap_change_24h")
    val marketCapChange24h: Float,
    @SerialName("market_cap_change_24h_in_currency")
    val marketCapChange24hInCurrency: com.icarumbas.coingecko.coins.models.responses.CoinGeckoMarketCapChangeInCurrencyResponse,
    @SerialName("market_cap_change_percentage_24h")
    val marketCapChangePercentage24h: Float,
    @SerialName("market_cap_change_percentage_24h_in_currency")
    val marketCapChangePercentage24hInCurrency: com.icarumbas.coingecko.coins.models.responses.CoinGeckoMarketCapChangePercentageInCurrencyResponse,
    @SerialName("market_cap_rank")
    val marketCapRank: Long?,
    @SerialName("price_change_24h")
    val priceChange24h: Float,
    @SerialName("price_change_24h_in_currency")
    val priceChange24hInCurrency: com.icarumbas.coingecko.coins.models.responses.CoinGeckoPriceInCurrencyResponse,
    @SerialName("price_change_percentage_14d")
    val priceChangePercentage14d: Float,
    @SerialName("price_change_percentage_14d_in_currency")
    val priceChangePercentage14dInCurrency: com.icarumbas.coingecko.coins.models.responses.CoinGeckoPriceInCurrencyResponse,
    @SerialName("price_change_percentage_1h_in_currency")
    val priceChangePercentage1hInCurrency: com.icarumbas.coingecko.coins.models.responses.CoinGeckoPriceInCurrencyResponse,
    @SerialName("price_change_percentage_1y")
    val priceChangePercentage1y: Float,
    @SerialName("price_change_percentage_1y_in_currency")
    val priceChangePercentage1yInCurrency: com.icarumbas.coingecko.coins.models.responses.CoinGeckoPriceInCurrencyResponse,
    @SerialName("price_change_percentage_200d")
    val priceChangePercentage200d: Float,
    @SerialName("price_change_percentage_200d_in_currency")
    val priceChangePercentage200dInCurrency: com.icarumbas.coingecko.coins.models.responses.CoinGeckoPriceInCurrencyResponse,
    @SerialName("price_change_percentage_24h")
    val priceChangePercentage24h: Float,
    @SerialName("price_change_percentage_24h_in_currency")
    val priceChangePercentage24hInCurrency: com.icarumbas.coingecko.coins.models.responses.CoinGeckoPriceInCurrencyResponse,
    @SerialName("price_change_percentage_30d")
    val priceChangePercentage30d: Float,
    @SerialName("price_change_percentage_30d_in_currency")
    val priceChangePercentage30dInCurrency: com.icarumbas.coingecko.coins.models.responses.CoinGeckoPriceInCurrencyResponse,
    @SerialName("price_change_percentage_60d")
    val priceChangePercentage60d: Float,
    @SerialName("price_change_percentage_60d_in_currency")
    val priceChangePercentage60dInCurrency: com.icarumbas.coingecko.coins.models.responses.CoinGeckoPriceInCurrencyResponse,
    @SerialName("price_change_percentage_7d")
    val priceChangePercentage7d: Float,
    @SerialName("price_change_percentage_7d_in_currency")
    val priceChangePercentage7dInCurrency: com.icarumbas.coingecko.coins.models.responses.CoinGeckoPriceInCurrencyResponse,
    @SerialName("total_volume")
    val totalVolume: com.icarumbas.coingecko.coins.models.responses.CoinGeckoTotalVolumeResponse
)