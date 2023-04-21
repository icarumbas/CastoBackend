package com.icarumbas.binance.api


import com.icarumbas.binance.repository.BinanceCredentialRepository
import com.icarumbas.casto.crypto.bytesToHexUTF8
import com.icarumbas.casto.crypto.hmacSha256
import com.icarumbas.core.RequestUserInfoHandler
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

        val uriComponentsBuilder = UriComponentsBuilder.fromHttpRequest(request)
            .queryParam(TIMESTAMP_KEY, timestamp)
        val tmpUriComponents = uriComponentsBuilder.build()

        val message = tmpUriComponents.queryParams.entries.joinToString(separator = "&") { entry ->
            val name = entry.key
            val value = entry.value.first().toString()
            "$name=$value"
        }
        val hmac = hmacSha256(message, credentials.privateKey)
        val signature = bytesToHexUTF8(hmac)

        val newUri = uriComponentsBuilder
            .queryParam(SIGNATURE_PARAMETER, signature)
            .build()
            .toUri()

        val modifiedRequest: HttpRequest = object : HttpRequestWrapper(request) {
            override fun getURI(): URI {
                return newUri
            }
        }

        return execution.execute(modifiedRequest, body);
    }
}