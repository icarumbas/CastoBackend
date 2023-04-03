package com.icarumbas.casto.market.models.storage

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "coin-prices")
data class CoinPriceEntity(
    @Id
    val id: String,

    @Column
    val lastUpdated: String,

    @Column
    val price: Float,

    @Column
    val changePercent1h: Float,

    @Column
    val changePercent24h: Float,

    @Column
    val changePercent7d: Float,

    @Column
    val changePercent14d: Float,

    @Column
    val changePercent30d: Float,

    @Column
    val changePercent60d: Float,

    @Column
    val changePercent1y: Float,
)