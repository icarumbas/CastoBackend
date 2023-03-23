package com.icarumbas.casto.storage

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Not Found")
class StorageFileNotFoundException(
    message: String? = null,
    cause: Throwable? = null,
): RuntimeException(message, cause)