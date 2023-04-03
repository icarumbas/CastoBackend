package com.icarumbas.casto.market.models.storage

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "coin_ids")
data class CoinIdEntity(
    @Id
    val id: String,
    @Column
    val ticker: String,
    @Column
    val name: String,
)