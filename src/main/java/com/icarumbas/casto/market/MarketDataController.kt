package com.icarumbas.casto.market

import com.icarumbas.casto.market.models.domain.MarketDataResponse
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/market")
class MarketDataController(
    private val marketDataService: MarketDataService
) {

    @GetMapping(path = ["/coins-info"])
    fun getBaseMarketData(
        @RequestParam coins: List<String>,
        @RequestParam(required = false) currency: String?
    ): ResponseEntity<MarketDataResponse> {
        val response = marketDataService.getCoins(coins, currency)
        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(response)
    }

    @PostMapping(path = ["/load-ids"])
    fun getBaseMarketData(): ResponseEntity<String> {
        marketDataService.getCoinIds()
        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body("OK")
    }
}