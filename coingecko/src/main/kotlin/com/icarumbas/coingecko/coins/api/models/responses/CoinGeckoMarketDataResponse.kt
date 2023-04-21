package com.icarumbas.coingecko.coins.api.models.responses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoMarketDataResponse(
    @SerialName("ath")
    val ath: CoinGeckoAthResponse,
    @SerialName("ath_change_percentage")
    val athChangePercentage: CoinGeckoAthChangePercentageResponse,
    @SerialName("ath_date")
    val athDate: CoinGeckoAthDateResponse,
    @SerialName("atl")
    val atl: CoinGeckoAtlResponse,
    @SerialName("atl_change_percentage")
    val atlChangePercentage: CoinGeckoAtlChangePercentageResponse,
    @SerialName("atl_date")
    val atlDate: CoinGeckoAtlDateResponse,
    @SerialName("circulating_supply")
    val circulatingSupply: Float?,
    @SerialName("current_price")
    val currentPrice: CoinGeckoCurrentPriceResponse,
    @SerialName("high_24h")
    val high24h: CoinGeckoHigh24hResponse,
    @SerialName("last_updated")
    val lastUpdated: String,
    @SerialName("low_24h")
    val low24h: CoinGeckoLow24hResponse,
    @SerialName("market_cap")
    val marketCap: CoinGeckoMarketCapResponse,
    @SerialName("market_cap_change_24h")
    val marketCapChange24h: Float,
    @SerialName("market_cap_change_24h_in_currency")
    val marketCapChange24hInCurrency: CoinGeckoMarketCapChangeInCurrencyResponse,
    @SerialName("market_cap_change_percentage_24h")
    val marketCapChangePercentage24h: Float,
    @SerialName("market_cap_change_percentage_24h_in_currency")
    val marketCapChangePercentage24hInCurrency: CoinGeckoMarketCapChangePercentageInCurrencyResponse,
    @SerialName("market_cap_rank")
    val marketCapRank: Long?,
    @SerialName("price_change_24h")
    val priceChange24h: Float,
    @SerialName("price_change_24h_in_currency")
    val priceChange24hInCurrency: CoinGeckoPriceInCurrencyResponse,
    @SerialName("price_change_percentage_14d")
    val priceChangePercentage14d: Float,
    @SerialName("price_change_percentage_14d_in_currency")
    val priceChangePercentage14dInCurrency: CoinGeckoPriceInCurrencyResponse,
    @SerialName("price_change_percentage_1h_in_currency")
    val priceChangePercentage1hInCurrency: CoinGeckoPriceInCurrencyResponse,
    @SerialName("price_change_percentage_1y")
    val priceChangePercentage1y: Float,
    @SerialName("price_change_percentage_1y_in_currency")
    val priceChangePercentage1yInCurrency: CoinGeckoPriceInCurrencyResponse,
    @SerialName("price_change_percentage_200d")
    val priceChangePercentage200d: Float,
    @SerialName("price_change_percentage_200d_in_currency")
    val priceChangePercentage200dInCurrency: CoinGeckoPriceInCurrencyResponse,
    @SerialName("price_change_percentage_24h")
    val priceChangePercentage24h: Float,
    @SerialName("price_change_percentage_24h_in_currency")
    val priceChangePercentage24hInCurrency: CoinGeckoPriceInCurrencyResponse,
    @SerialName("price_change_percentage_30d")
    val priceChangePercentage30d: Float,
    @SerialName("price_change_percentage_30d_in_currency")
    val priceChangePercentage30dInCurrency: CoinGeckoPriceInCurrencyResponse,
    @SerialName("price_change_percentage_60d")
    val priceChangePercentage60d: Float,
    @SerialName("price_change_percentage_60d_in_currency")
    val priceChangePercentage60dInCurrency: CoinGeckoPriceInCurrencyResponse,
    @SerialName("price_change_percentage_7d")
    val priceChangePercentage7d: Float,
    @SerialName("price_change_percentage_7d_in_currency")
    val priceChangePercentage7dInCurrency: CoinGeckoPriceInCurrencyResponse,
    @SerialName("total_volume")
    val totalVolume: CoinGeckoTotalVolumeResponse
)