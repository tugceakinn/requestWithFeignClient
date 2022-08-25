package com.example.requestwithfeignclient

import com.example.requestwithfeignclient.infra.config.registerSwagger
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@SpringBootApplication
@EnableFeignClients
class RequestWithFeignClientApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder()
        .initializers(
            registerSwagger()
        )
        .sources(RequestWithFeignClientApplication::class.java)
        .run(*args)
}

