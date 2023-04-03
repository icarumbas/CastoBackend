package com.icarumbas.casto.binance.dependencies

import com.icarumbas.casto.binance.api.BinanceRequestInterceptor
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory
import org.springframework.http.converter.json.KotlinSerializationJsonHttpMessageConverter
import org.springframework.web.client.RestTemplate


@Configuration
open class BinanceApiDependencies {

    @Bean(name = ["binance"])
    open fun binanceRestTemplate(
        binanceRequestInterceptor: BinanceRequestInterceptor,
        messageConverter: KotlinSerializationJsonHttpMessageConverter
    ): RestTemplate {
        return RestTemplateBuilder()
            .messageConverters(messageConverter)
            .additionalInterceptors(binanceRequestInterceptor)
            .requestFactory(OkHttp3ClientHttpRequestFactory::class.java)
            .build()
    }
}