package com.icarumbas.casto.coingecko.dependencies

import com.icarumbas.casto.coingecko.exchanges.api.ExchangesApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.create


private const val BASE_URL = "https://api.coingecko.com/api/v3/"

@Configuration
open class ApiDependencies {



    @Bean(name = ["CoinGecko"])
    open fun coinGeckoRestTemplate(json: Json): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }

    @Bean
    open fun exchangesApi(
        @Qualifier("CoinGecko") retrofit: Retrofit
    ): ExchangesApi {
        return retrofit.create()
    }
}