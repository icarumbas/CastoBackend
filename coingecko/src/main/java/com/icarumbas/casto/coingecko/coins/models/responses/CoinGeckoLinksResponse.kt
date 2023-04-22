package com.icarumbas.casto.coingecko.coins.models.responses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoLinksResponse(
    @SerialName("announcement_url")
    val announcementUrl: List<String>,
    @SerialName("blockchain_site")
    val blockchainSite: List<String>,
    @SerialName("chat_url")
    val chatUrl: List<String>,
    @SerialName("facebook_username")
    val facebookUsername: String?,
    @SerialName("homepage")
    val homepage: List<String>,
    @SerialName("official_forum_url")
    val officialForumUrl: List<String>,
    @SerialName("repos_url")
    val reposUrl: CoinGeckoReposUrlResponse?,
    @SerialName("subreddit_url")
    val subredditUrl: String?,
    @SerialName("telegram_channel_identifier")
    val telegramChannelIdentifier: String?,
    @SerialName("twitter_screen_name")
    val twitterScreenName: String?
)