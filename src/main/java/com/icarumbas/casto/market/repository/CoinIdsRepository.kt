package com.icarumbas.casto.market.repository

import com.icarumbas.casto.market.models.storage.CoinId
import org.springframework.data.jpa.repository.JpaRepository

interface CoinIdsRepository : JpaRepository<CoinId, String> {

    fun getByTickerIgnoreCase(ticker: String): CoinId?
}