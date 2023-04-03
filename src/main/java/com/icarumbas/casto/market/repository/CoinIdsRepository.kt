package com.icarumbas.casto.market.repository

import com.icarumbas.casto.market.models.storage.CoinIdEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CoinIdsRepository : JpaRepository<CoinIdEntity, String> {

    fun getByTickerIgnoreCase(ticker: String): CoinIdEntity
}