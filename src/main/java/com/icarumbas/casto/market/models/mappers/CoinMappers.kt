package com.icarumbas.casto.market.models.mappers

import com.icarumbas.casto.market.models.coingecko.CoinGeckoCoinIdItemResponse
import com.icarumbas.casto.market.models.coingecko.CoinGeckoCoinResponse
import com.icarumbas.casto.market.models.coingecko.CoinGeckoSearchCoinResponse
import com.icarumbas.casto.market.models.storage.CoinId

fun CoinGeckoCoinIdItemResponse.toCoinId(): CoinId {
    return CoinId(id, symbol, name)
}

fun CoinGeckoCoinResponse.toCoinId(): CoinId {
    return CoinId(id, symbol, name)
}