package com.icarumbas.casto.portfolio

import com.icarumbas.casto.portfolio.models.requests.BinanceCredentialsRequest
import com.icarumbas.casto.portfolio.responses.PortfolioDataResponse
import com.icarumbas.casto.user.dependencies.RequestUserInfoHandler
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/portfolio")
class PortfolioController(
    private val portfolioService: PortfolioService,
    private val userInfoHandler: RequestUserInfoHandler,
) {

    @PostMapping(path = ["/save-binance-credentials"])
    fun provideBinanceCredentials(
        @RequestParam id: String,
        @RequestBody credentials: BinanceCredentialsRequest
    ): String {
        userInfoHandler.setId(id)
        portfolioService.saveBinanceCredentials(credentials)
        return "Credentials saved"
    }

    @PostMapping(path = ["/user-assets"])
    fun getBaseMarketData(
        @RequestParam id: String,
    ): ResponseEntity<PortfolioDataResponse> {
        userInfoHandler.setId(id)
        val response = portfolioService.getPortfolio()
        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(response)
    }
}