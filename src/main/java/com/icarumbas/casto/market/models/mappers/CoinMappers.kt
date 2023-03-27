package com.icarumbas.casto.market.models.mappers

import com.icarumbas.casto.market.models.api.CoinGeckoCoinResponse
import com.icarumbas.casto.market.models.storage.CoinId

fun CoinGeckoCoinResponse.toCoinId(): CoinId {
    return CoinId(symbol, id)
}