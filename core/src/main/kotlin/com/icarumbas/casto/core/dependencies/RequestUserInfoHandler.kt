package com.icarumbas.casto.core.dependencies

import java.lang.IllegalStateException
import java.util.*

open class RequestUserInfoHandler {

    private var _id: UUID? = null

    fun getId(): UUID {
        return _id ?: throw IllegalStateException("Request id not provided")
    }

    fun setId(id: String) {
        this._id = UUID.fromString(id)
    }
}