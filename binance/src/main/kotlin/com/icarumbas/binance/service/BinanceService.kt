package com.icarumbas.binance.service

import com.icarumbas.binance.models.BinanceCredentials
import com.icarumbas.binance.repository.BinanceCredentialRepository
import com.icarumbas.core.RequestUserInfoHandler
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