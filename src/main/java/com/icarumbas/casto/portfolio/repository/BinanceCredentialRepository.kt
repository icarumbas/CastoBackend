package com.icarumbas.casto.portfolio.repository

import com.icarumbas.casto.portfolio.models.storage.UserBinanceCredentials
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface BinanceCredentialRepository : JpaRepository<UserBinanceCredentials, UUID>