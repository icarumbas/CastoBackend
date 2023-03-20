package com.icarumbas.casto.storage

class StorageException(
    message: String? = null,
    cause: Throwable? = null,
): RuntimeException(message, cause)