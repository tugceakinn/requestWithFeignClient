package com.example.requestwithfeignclient

import com.example.requestwithfeignclient.infra.config.registerSwagger
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import java.util.*
import javax.annotation.PostConstruct

@SpringBootApplication
@EnableFeignClients
@EnableElasticsearchRepositories
class RequestWithFeignClientApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder()
        .initializers(
            registerSwagger()
        )
        .sources(RequestWithFeignClientApplication::class.java)
        .run(*args)
}

