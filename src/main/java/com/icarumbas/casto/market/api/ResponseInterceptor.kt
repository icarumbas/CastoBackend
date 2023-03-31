package com.icarumbas.casto.market.api

import org.slf4j.LoggerFactory
import org.springframework.http.HttpRequest
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets

@Component
class ResponseInterceptor : ClientHttpRequestInterceptor {

    private val logger = LoggerFactory.getLogger(ResponseInterceptor::class.java)

    override fun intercept(
        request: HttpRequest,
        body: ByteArray,
        execution: ClientHttpRequestExecution
    ): ClientHttpResponse {
        val response = execution.execute(request, body)
//        val responseStr = String(response.body.readAllBytes(), StandardCharsets.UTF_8)
//        logger.debug("Receive response: $responseStr")
        return response
    }
}