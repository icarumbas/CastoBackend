package com.icarumbas.casto.coingecko.exchanges.api

import com.icarumbas.casto.coingecko.exchanges.models.responses.CoinGeckoExchangeTickersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ExchangesApi {

    /**
     * Get exchange tickers (paginated)
     *
     * IMPORTANT:
     * Ticker is_stale is true when ticker that has not been updated/unchanged
     * from the exchange for a while.
     * Ticker is_anomaly is true if ticker's price is outliered by our system.
     * You are responsible for managing how you want to display these information
     * (e.g. footnote, different background, change opacity, hide)
     * */
    @GET("exchanges/{exchange}/tickers")
    fun tickersForExchange(
        @Path("exchange") exchange: String,
        @Query("page") page: Int
    ): Call<CoinGeckoExchangeTickersResponse>
}