package com.icarumbas.casto.market.repository

import com.icarumbas.casto.market.models.storage.CoinPriceEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CoinPricesRepository : JpaRepository<CoinPriceEntity, String>