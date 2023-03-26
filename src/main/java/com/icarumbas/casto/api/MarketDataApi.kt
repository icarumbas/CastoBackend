package com.icarumbas.casto.api

import com.icarumbas.casto.api.models.CoinIdMapDataResponse

interface MarketDataApi {

    fun getCoinIdMap(): CoinIdMapDataResponse
}