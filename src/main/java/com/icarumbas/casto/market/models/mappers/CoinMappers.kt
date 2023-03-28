package com.icarumbas.casto.market.models.mappers

import com.icarumbas.casto.market.models.coingecko.CoinGeckoCoinIdItemResponse
import com.icarumbas.casto.market.models.storage.CoinId

fun CoinGeckoCoinIdItemResponse.toCoinId(): CoinId {
    return CoinId(symbol, id)
}