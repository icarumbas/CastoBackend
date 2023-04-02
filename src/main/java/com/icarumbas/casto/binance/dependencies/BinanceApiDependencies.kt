package com.icarumbas.casto.binance.dependencies

import com.icarumbas.casto.binance.BinanceRequestInterceptor
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory
import org.springframework.http.converter.json.KotlinSerializationJsonHttpMessageConverter
import org.springframework.web.client.RestTemplate

private const val BINANCE_BASE_URL = "https://api.binance.com"
private const val BINANCE_SAPI_ENDPOINT = "sapi/v3"
private const val BINANCE_API_ENDPOINT = "api/v3"


@Configuration
open class BinanceApiDependencies {

    @Bean(name = ["binance-builder"])
    open fun binanceRestTemplate(
        binanceRequestInterceptor: BinanceRequestInterceptor,
        messageConverter: KotlinSerializationJsonHttpMessageConverter
    ): RestTemplateBuilder {
        return RestTemplateBuilder()
            .messageConverters(messageConverter)
            .additionalInterceptors(binanceRequestInterceptor)
            .requestFactory(OkHttp3ClientHttpRequestFactory::class.java)
    }

    @Bean(name = ["binance-sapi"])
    open fun binanceSapi(
        @Qualifier("binance-builder")
        builder: RestTemplateBuilder
    ): RestTemplate {
        return builder.rootUri("$BINANCE_BASE_URL/$BINANCE_SAPI_ENDPOINT")
            .build()
    }

    @Bean(name = ["binance-api"])
    open fun binanceApi(
        @Qualifier("binance-builder")
        builder: RestTemplateBuilder
    ): RestTemplate {
        return builder.rootUri("$BINANCE_BASE_URL/$BINANCE_API_ENDPOINT")
            .build()
    }
}