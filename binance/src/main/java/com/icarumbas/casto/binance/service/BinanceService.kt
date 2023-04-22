package com.icarumbas.casto.binance.service

import com.icarumbas.casto.binance.models.BinanceCredentials
import com.icarumbas.casto.binance.repository.BinanceCredentialRepository
import com.icarumbas.casto.core.dependencies.RequestUserInfoHandler
import org.springframework.stereotype.Service


@Service
class BinanceService(
    private val repository: BinanceCredentialRepository,
    private val userInfoHandler: RequestUserInfoHandler,
) {

    fun saveCredentials(
        publicKey: String,
        privateKey: String
    ) {
        val id = userInfoHandler.getId()
        val entity = BinanceCredentials(id, publicKey, privateKey)
        repository.save(entity)
    }
}