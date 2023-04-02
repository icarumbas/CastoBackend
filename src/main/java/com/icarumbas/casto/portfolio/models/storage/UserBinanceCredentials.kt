package com.icarumbas.casto.portfolio.models.storage

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "binance-credentials")
data class UserBinanceCredentials(
    @Id
    val id: UUID,
    val publicKey: String,
    val privateKey: String,
)