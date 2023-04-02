package com.icarumbas.casto.user

import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserIdentifierService {

    fun generateUUID(): UUID {
        return UUID.randomUUID()
    }
}