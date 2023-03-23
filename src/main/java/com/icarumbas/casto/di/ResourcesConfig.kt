package com.icarumbas.casto.di

import jakarta.annotation.Resource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.nio.file.Path
import java.nio.file.Paths

@Configuration
open class ResourcesConfig {

    @Bean(name = ["baseFilePath"])
    open fun baseFilePath(): Path {
        return Paths.get(System.getProperty("user.dir"), "/out")
    }
}