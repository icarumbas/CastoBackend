package com.icarumbas.casto.icons

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class IconsController @Autowired constructor(
    private val iconsStorageService: IconsStorageService
) {
    @GetMapping(
        "/{ticker}",
        MediaType.IMAGE_PNG_VALUE
    )
    fun getIcon(@PathVariable ticker: String): ByteArray {
        val resource = iconsStorageService.loadAsResource(ticker)
        return resource.contentAsByteArray
    }

}