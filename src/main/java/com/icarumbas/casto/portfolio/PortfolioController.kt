package com.icarumbas.casto.portfolio

import com.icarumbas.binance.service.BinanceService
import com.icarumbas.casto.portfolio.models.requests.BinanceCredentialsRequest
import com.icarumbas.casto.portfolio.models.responses.PortfolioDataResponse
import com.icarumbas.core.RequestUserInfoHandler
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/portfolio")
class PortfolioController(
    private val binanceService: BinanceService,
    private val userInfoHandler: RequestUserInfoHandler,
) {

    @PostMapping(path = ["/save-binance-credentials"])
    fun provideBinanceCredentials(
        @RequestParam id: String,
        @RequestBody credentials: BinanceCredentialsRequest
    ): String {
        userInfoHandler.setId(id)
        binanceService.saveCredentials(credentials.publicKey, credentials.privateKey)
        return "Credentials saved"
    }

    @GetMapping(path = ["/holdings"])
    fun getPortfolio(
        @RequestParam id: String,
    ): ResponseEntity<PortfolioDataResponse> {
        userInfoHandler.setId(id)
        val response = null
        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(response)
    }
}