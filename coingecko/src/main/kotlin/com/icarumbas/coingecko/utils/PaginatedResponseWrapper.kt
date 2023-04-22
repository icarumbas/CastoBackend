package com.icarumbas.coingecko.utils


class PaginatedResponseWrapper<T>(
    val response: T,
    val pagedInfo: PaginatedResponseHeaders
)