package com.icarumbas.casto.market

import com.icarumbas.casto.market.models.responses.MarketDataResponse
import com.icarumbas.casto.market.models.requests.RequestCoinInfoData
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/market")
class MarketDataController(
    private val marketDataService: MarketDataService
) {

    @PostMapping(path = ["/coins-info"])
    fun getBaseMarketData(
        @RequestBody coins: RequestCoinInfoData,
    ): ResponseEntity<MarketDataResponse> {
        val response = marketDataService.getCoins(coins.data)
        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(response)
    }
}