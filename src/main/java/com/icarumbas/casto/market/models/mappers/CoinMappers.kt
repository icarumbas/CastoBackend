package com.icarumbas.casto.market.models.mappers

import com.icarumbas.casto.market.models.coingecko.CoinGeckoCoinIdItemResponse
import com.icarumbas.casto.market.models.coingecko.CoinGeckoCoinResponse
import com.icarumbas.casto.market.models.storage.CoinIdEntity

fun CoinGeckoCoinIdItemResponse.toCoinId(): CoinIdEntity {
    return CoinIdEntity(id, symbol, name)
}

fun CoinGeckoCoinResponse.toCoinId(): CoinIdEntity {
    return CoinIdEntity(id, symbol, name)
}