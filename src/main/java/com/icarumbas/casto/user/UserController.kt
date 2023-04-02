package com.icarumbas.casto.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val userIdentifierService: UserIdentifierService
) {

    @GetMapping(path = ["/generate-id"])
    fun generateUUID(): String {
        return userIdentifierService.generateUUID().toString()
    }
}