package com.icarumbas.casto.market.models.coingecko


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
    val circulatingSupply: Double,
    @SerialName("current_price")
    val currentPrice: CoinGeckoCurrentPriceResponse,
    @SerialName("fully_diluted_valuation")
    val fullyDilutedValuation: CoinGeckoFullyDilutedValuationResponse,
    @SerialName("high_24h")
    val high24h: CoinGeckoHigh24hResponse,
    @SerialName("last_updated")
    val lastUpdated: String,
    @SerialName("low_24h")
    val low24h: CoinGeckoLow24hResponse,
    @SerialName("market_cap")
    val marketCap: CoinGeckoMarketCapResponse,
    @SerialName("market_cap_change_24h")
    val marketCapChange24h: Int,
    @SerialName("market_cap_change_24h_in_currency")
    val marketCapChange24hInCurrency: CoinGeckoMarketCapChange24hInCurrencyResponse,
    @SerialName("market_cap_change_percentage_24h")
    val marketCapChangePercentage24h: Double,
    @SerialName("market_cap_change_percentage_24h_in_currency")
    val marketCapChangePercentage24hInCurrency: CoinGeckoMarketCapChangePercentage24hInCurrencyResponse,
    @SerialName("market_cap_rank")
    val marketCapRank: Int,
    @SerialName("price_change_24h")
    val priceChange24h: Double,
    @SerialName("price_change_24h_in_currency")
    val priceChange24hInCurrency: CoinGeckoPriceChange24hInCurrencyResponse,
    @SerialName("price_change_percentage_14d")
    val priceChangePercentage14d: Double,
    @SerialName("price_change_percentage_14d_in_currency")
    val priceChangePercentage14dInCurrency: CoinGeckoPriceChangePercentage14dInCurrencyResponse,
    @SerialName("price_change_percentage_1h_in_currency")
    val priceChangePercentage1hInCurrency: CoinGeckoPriceChangePercentage1hInCurrencyResponse,
    @SerialName("price_change_percentage_1y")
    val priceChangePercentage1y: Double,
    @SerialName("price_change_percentage_1y_in_currency")
    val priceChangePercentage1yInCurrency: CoinGeckoPriceChangePercentage1yInCurrencyResponse,
    @SerialName("price_change_percentage_200d")
    val priceChangePercentage200d: Double,
    @SerialName("price_change_percentage_200d_in_currency")
    val priceChangePercentage200dInCurrency: CoinGeckoPriceChangePercentage14dInCurrencyResponse,
    @SerialName("price_change_percentage_24h")
    val priceChangePercentage24h: Double,
    @SerialName("price_change_percentage_24h_in_currency")
    val priceChangePercentage24hInCurrency: CoinGeckoMarketCapChangePercentage24hInCurrencyResponse,
    @SerialName("price_change_percentage_30d")
    val priceChangePercentage30d: Double,
    @SerialName("price_change_percentage_30d_in_currency")
    val priceChangePercentage30dInCurrency: CoinGeckoPriceChangePercentage14dInCurrencyResponse,
    @SerialName("price_change_percentage_60d")
    val priceChangePercentage60d: Double,
    @SerialName("price_change_percentage_60d_in_currency")
    val priceChangePercentage60dInCurrency: CoinGeckoPriceChangePercentage14dInCurrencyResponse,
    @SerialName("price_change_percentage_7d")
    val priceChangePercentage7d: Double,
    @SerialName("price_change_percentage_7d_in_currency")
    val priceChangePercentage7dInCurrency: CoinGeckoPriceChangePercentage14dInCurrencyResponse,
    @SerialName("total_volume")
    val totalVolume: CoinGeckoTotalVolumeResponse
)