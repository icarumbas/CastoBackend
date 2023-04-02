package com.icarumbas.casto.portfolio

import com.icarumbas.casto.portfolio.mappers.toUserBinanceCredentials
import com.icarumbas.casto.portfolio.models.requests.BinanceCredentialsRequest
import com.icarumbas.casto.portfolio.repository.BinanceCredentialRepository
import com.icarumbas.casto.user.dependencies.RequestUserInfoHandler
import org.springframework.stereotype.Service
import java.lang.IllegalStateException
import java.util.UUID

@Service
class PortfolioService(
    private val binanceCredentialRepository: BinanceCredentialRepository,
    private val userInfoHandler: RequestUserInfoHandler,
) {

    fun saveBinanceCredentials(credentials: BinanceCredentialsRequest) {
        val uuid = userInfoHandler.getId()
        binanceCredentialRepository.save(credentials.toUserBinanceCredentials(uuid))
    }
}