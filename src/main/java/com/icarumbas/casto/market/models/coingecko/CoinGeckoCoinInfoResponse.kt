package com.icarumbas.casto.market.models.coingecko


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoCoinInfoResponse(
    @SerialName("asset_platform_id")
    val assetPlatformId: String?,
    @SerialName("block_time_in_minutes")
    val blockTimeInMinutes: Long?,
    @SerialName("categories")
    val categories: List<String>,
    @SerialName("coingecko_rank")
    val coingeckoRank: Long?,
    @SerialName("coingecko_score")
    val coingeckoScore: Float,
    @SerialName("community_score")
    val communityScore: Float?,
    @SerialName("country_origin")
    val countryOrigin: String?,
    @SerialName("description")
    val description: CoinGeckoDescriptionResponse?,
    @SerialName("developer_score")
    val developerScore: Float?,
    @SerialName("genesis_date")
    val genesisDate: String?,
    @SerialName("hashing_algorithm")
    val hashingAlgorithm: String?,
    @SerialName("id")
    val id: String,
    @SerialName("image")
    val image: CoinGeckoImageResponse,
    @SerialName("last_updated")
    val lastUpdated: String,
    @SerialName("links")
    val links: CoinGeckoLinksResponse,
    @SerialName("liquidity_score")
    val liquidityScore: Float?,
    @SerialName("market_cap_rank")
    val marketCapRank: Long?,
    @SerialName("market_data")
    val marketData: CoinGeckoMarketDataResponse,
    @SerialName("name")
    val name: String,
    @SerialName("public_interest_score")
    val publicInterestScore: Float?,
    @SerialName("sentiment_votes_down_percentage")
    val sentimentVotesDownPercentage: Float?,
    @SerialName("sentiment_votes_up_percentage")
    val sentimentVotesUpPercentage: Float?,
    @SerialName("symbol")
    val symbol: String
)