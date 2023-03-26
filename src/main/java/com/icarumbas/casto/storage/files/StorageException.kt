package com.icarumbas.casto.storage.files

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
class StorageException(
    message: String? = null,
    cause: Throwable? = null,
): RuntimeException(message, cause)