package com.icarumbas.casto.storage

class StorageFileNotFoundException(
    message: String? = null,
    cause: Throwable? = null,
): RuntimeException(message, cause)