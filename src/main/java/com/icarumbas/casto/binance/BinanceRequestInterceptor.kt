package com.icarumbas.casto.binance

import com.icarumbas.casto.crypto.bytesToHexUTF8
import com.icarumbas.casto.crypto.hmacSha256
import com.icarumbas.casto.portfolio.repository.BinanceCredentialRepository
import com.icarumbas.casto.user.dependencies.RequestUserInfoHandler
import org.springframework.http.HttpRequest
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse
import org.springframework.http.client.support.HttpRequestWrapper
import org.springframework.stereotype.Component
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

private const val TIMESTAMP_KEY = "timestamp"
private const val APIKEY_HEADER = "X-MBX-APIKEY"
private const val SIGNATURE_PARAMETER = "signature"

@Component
class BinanceRequestInterceptor(
    private val userInfoHandler: RequestUserInfoHandler,
    private val binanceCredentialRepository: BinanceCredentialRepository,
) : ClientHttpRequestInterceptor {

    override fun intercept(
        request: HttpRequest,
        body: ByteArray,
        execution: ClientHttpRequestExecution
    ): ClientHttpResponse {
        val id = userInfoHandler.getId()
        val credentials = binanceCredentialRepository.getReferenceById(id)
        request.headers.add(APIKEY_HEADER, credentials.publicKey)

        val timestamp = System.currentTimeMillis()

        val uriComponents = UriComponentsBuilder.fromHttpRequest(request)
            .queryParam(TIMESTAMP_KEY, timestamp)
            .build()

        val message = uriComponents.queryParams.entries.joinToString(separator = "&") { entry ->
            val name = entry.key
            val value = entry.value.first().toString()
            "$name=$value"
        }
        val hmac = hmacSha256(message, credentials.privateKey)
        val signature = bytesToHexUTF8(hmac)

        uriComponents.queryParams.add(SIGNATURE_PARAMETER, signature)
        val newUri = uriComponents.toUri()

        val modifiedRequest: HttpRequest = object : HttpRequestWrapper(request) {
            override fun getURI(): URI {
                return newUri
            }
        }

        return execution.execute(modifiedRequest, body);
    }
}