package com.icarumbas.casto.coingecko.exchanges.models.responses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoTickerResponse(
    @SerialName("base")
    val base: String,
    @SerialName("bid_ask_spread_percentage")
    val bidAskSpreadPercentage: Float,
    @SerialName("coin_id")
    val coinId: String,
    @SerialName("converted_last")
    val convertedLast: CoinGeckoConvertedLastResponse,
    @SerialName("converted_volume")
    val convertedVolume: CoinGeckoConvertedVolumeResponse,
    @SerialName("is_anomaly")
    val isAnomaly: Boolean,
    @SerialName("is_stale")
    val isStale: Boolean,
    @SerialName("last")
    val last: Float,
    @SerialName("last_fetch_at")
    val lastFetchAt: String,
    @SerialName("last_traded_at")
    val lastTradedAt: String,
    @SerialName("market")
    val market: CoinGeckoMarketResponse,
    @SerialName("target")
    val target: String,
    @SerialName("target_coin_id")
    val targetCoinId: String? = null,
    @SerialName("timestamp")
    val timestamp: String,
    @SerialName("trade_url")
    val tradeUrl: String,
    @SerialName("trust_score")
    val trustScore: String,
    @SerialName("volume")
    val volume: Double
)