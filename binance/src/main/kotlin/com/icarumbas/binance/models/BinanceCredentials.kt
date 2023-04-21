package com.icarumbas.binance.models

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "binance-credentials")
data class BinanceCredentials(
    @Id
    val id: UUID,
    val publicKey: String,
    val privateKey: String,
)