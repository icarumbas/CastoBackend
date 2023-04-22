package com.icarumbas.casto.coingecko.storage

import com.icarumbas.casto.coingecko.coins.models.entities.CoinIdEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CoinIdsRepository : JpaRepository<CoinIdEntity, String> {

    fun getByTickerIgnoreCase(ticker: String): CoinIdEntity
}