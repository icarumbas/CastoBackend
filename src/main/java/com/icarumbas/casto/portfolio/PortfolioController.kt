package com.icarumbas.casto.portfolio

import com.icarumbas.casto.portfolio.models.requests.BinanceCredentialsRequest
import com.icarumbas.casto.user.dependencies.RequestUserInfoHandler
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/portfolio")
class PortfolioController(
    private val portfolioService: PortfolioService,
    private val userInfoHandler: RequestUserInfoHandler,
) {

    @PostMapping(path = ["/save-binance"])
    fun provideBinanceCredentials(
        @RequestParam id: String,
        @RequestBody credentials: BinanceCredentialsRequest
    ): String {
        userInfoHandler.setId(id)
        portfolioService.saveBinanceCredentials(credentials)
        return "Credentials saved"
    }
}