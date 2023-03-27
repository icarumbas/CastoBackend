package com.icarumbas.casto.market.models.storage

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "coin_ids")
data class CoinId(
    @Id
    val ticker: String,
    @Column
    val coinGeckoId: String
)