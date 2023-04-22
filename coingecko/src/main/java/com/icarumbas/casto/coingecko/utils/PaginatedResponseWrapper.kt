package com.icarumbas.casto.coingecko.utils


class PaginatedResponseWrapper<T>(
    val response: T,
    val pagedInfo: PaginatedResponseHeaders
)