package com.icarumbas.binance.repository

import com.icarumbas.binance.models.BinanceCredentials
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface BinanceCredentialRepository : JpaRepository<BinanceCredentials, UUID>