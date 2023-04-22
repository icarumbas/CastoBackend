package com.icarumbas.casto.coingecko.dependencies

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory
import org.springframework.http.converter.json.KotlinSerializationJsonHttpMessageConverter
import org.springframework.web.client.RestTemplate


private const val BASE_URL = "https://api.coingecko.com/api/v3"

@Configuration
open class ApiDependencies {

    @Bean(name = ["CoinGecko"])
    open fun coinGeckoRestTemplate(
        messageConverter: KotlinSerializationJsonHttpMessageConverter,
    ): RestTemplate {
        return RestTemplateBuilder()
            .messageConverters(messageConverter)
            .requestFactory(OkHttp3ClientHttpRequestFactory::class.java)
            .rootUri(BASE_URL)
            .build()
    }
}