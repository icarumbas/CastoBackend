package com.icarumbas.casto.dependencies

import kotlinx.serialization.json.Json
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.KotlinSerializationJsonHttpMessageConverter

@Configuration
open class JsonConfiguration {

    @Bean
    open fun json(): Json {
        return Json {
            ignoreUnknownKeys = true
            isLenient = true
        }
    }

    @Bean
    open fun kotlinSerializationMessageConverter(json: Json): KotlinSerializationJsonHttpMessageConverter {
        return KotlinSerializationJsonHttpMessageConverter(json)
    }
}