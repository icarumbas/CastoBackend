package com.icarumbas.casto.playground

import com.icarumbas.casto.coingecko.exchanges.service.ExchangesService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/play")
class PlayController(
    private val exchangesService: ExchangesService
) {

    @GetMapping(path = ["/binance"])
    fun getBinanceCoinIds(): String {
        exchangesService.loadBinanceTickers()
        return "OK"
    }
}