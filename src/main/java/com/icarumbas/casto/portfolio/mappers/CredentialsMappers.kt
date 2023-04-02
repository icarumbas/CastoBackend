package com.icarumbas.casto.portfolio.mappers

import com.icarumbas.casto.portfolio.models.requests.BinanceCredentialsRequest
import com.icarumbas.casto.portfolio.models.storage.UserBinanceCredentials
import java.util.UUID

fun BinanceCredentialsRequest.toUserBinanceCredentials(id: UUID): UserBinanceCredentials
    = UserBinanceCredentials(id, publicKey, privateKey)