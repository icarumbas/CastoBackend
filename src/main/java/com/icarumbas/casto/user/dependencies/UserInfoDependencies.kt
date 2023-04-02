package com.icarumbas.casto.user.dependencies

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.context.annotation.RequestScope

@Configuration
open class UserInfoDependencies {

    @Bean
    @RequestScope
    open fun provideRequestUserInfoHandler(): RequestUserInfoHandler {
        return RequestUserInfoHandler()
    }
}