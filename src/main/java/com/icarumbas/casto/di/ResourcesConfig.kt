package com.icarumbas.casto.di

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

    @Bean(name = ["baseIconsPath"])
    open fun baseIconsPath(): Path {
        return baseFilePath().resolve("icons")
    }

    @Bean(name = ["svgIconsPath"])
    open fun svgIconsPath(): Path {
        return baseIconsPath().resolve("svg")
    }

    @Bean(name = ["pngIconsPath"])
    open fun pngIconsPath(): Path {
        return baseIconsPath().resolve("png")
    }
}