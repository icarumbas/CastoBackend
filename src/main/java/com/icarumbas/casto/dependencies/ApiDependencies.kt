package com.icarumbas.casto.dependencies

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.ClientHttpRequestFactory
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory
import org.springframework.web.client.RestTemplate

private const val BASE_URL = "https://api.coingecko.com/api/v3"

@Configuration
open class ApiDependencies {

    @Bean(name = ["CoinGecko"])
    open fun coinGeckoRestTemplate(): RestTemplate {
        return RestTemplateBuilder()
            .rootUri(BASE_URL)
            .requestFactory(OkHttp3ClientHttpRequestFactory::class.java)
            .build()
    }
}