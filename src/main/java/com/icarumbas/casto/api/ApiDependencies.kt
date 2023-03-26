package com.icarumbas.casto.api

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.ClientHttpRequestFactory
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory
import org.springframework.web.client.RestTemplate

private const val BASE_URL = "https://rest-sandbox.coinapi.io"
private const val API_KEY_HEADER = "X-CoinAPI-Key"
private const val COIN_API_KEY = "F62AD5D0-393B-4092-9AF1-30B77A75735A"

@Configuration
open class ApiDependencies {

    @Bean(name = ["coinApi"])
    open fun coinApiRestTemplate(requestFactory: ClientHttpRequestFactory): RestTemplate {
        return RestTemplateBuilder()
            .defaultHeader(API_KEY_HEADER, COIN_API_KEY)
            .rootUri(BASE_URL)
            .requestFactory(OkHttp3ClientHttpRequestFactory::class.java)
            .build()
    }
}