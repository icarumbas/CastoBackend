package com.icarumbas.casto.user.dependencies

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.context.annotation.RequestScope

@Configuration
class UserInfoDependencies {

    @Bean
    @RequestScope
    fun provideRequestUserInfoHandler(): RequestUserInfoHandler {
        return RequestUserInfoHandler()
    }
}