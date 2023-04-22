package com.icarumbas.coingecko.coins.storage

import com.icarumbas.coingecko.coins.models.entities.CoinIdEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CoinIdsRepository : JpaRepository<CoinIdEntity, String> {

    fun getByTickerIgnoreCase(ticker: String): CoinIdEntity
}