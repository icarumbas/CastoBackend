package com.icarumbas.casto.market.models.coingecko


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoCoinInfoResponse(
    @SerialName("asset_platform_id")
    val assetPlatformId: String?,
    @SerialName("block_time_in_minutes")
    val blockTimeInMinutes: Int,
    @SerialName("categories")
    val categories: List<String>,
    @SerialName("coingecko_rank")
    val coingeckoRank: Int,
    @SerialName("coingecko_score")
    val coingeckoScore: Double,
    @SerialName("community_score")
    val communityScore: Double,
    @SerialName("country_origin")
    val countryOrigin: String,
    @SerialName("description")
    val description: CoinGeckoDescriptionResponse,
    @SerialName("detail_platforms")
    val detailPlatforms: CoinGeckoDetailPlatformsResponse,
    @SerialName("developer_score")
    val developerScore: Double,
    @SerialName("genesis_date")
    val genesisDate: String,
    @SerialName("hashing_algorithm")
    val hashingAlgorithm: String,
    @SerialName("id")
    val id: String,
    @SerialName("image")
    val image: CoinGeckoImageResponse,
    @SerialName("last_updated")
    val lastUpdated: String,
    @SerialName("links")
    val links: CoinGeckoLinksResponse,
    @SerialName("liquidity_score")
    val liquidityScore: Double,
    @SerialName("market_cap_rank")
    val marketCapRank: Int,
    @SerialName("market_data")
    val marketData: CoinGeckoMarketDataResponse,
    @SerialName("name")
    val name: String,
    @SerialName("platforms")
    val platforms: CoinGeckoPlatformsResponse,
    @SerialName("public_interest_score")
    val publicInterestScore: Double,
    @SerialName("public_interest_stats")
    val publicInterestStats: CoinGeckoPublicInterestStatsResponse,
    @SerialName("sentiment_votes_down_percentage")
    val sentimentVotesDownPercentage: Double,
    @SerialName("sentiment_votes_up_percentage")
    val sentimentVotesUpPercentage: Double,
    @SerialName("symbol")
    val symbol: String
)