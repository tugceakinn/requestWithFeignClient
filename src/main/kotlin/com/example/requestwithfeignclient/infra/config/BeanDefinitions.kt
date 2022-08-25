package com.example.requestwithfeignclient.infra.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.beans


fun registerSwagger() = beans {
    bean {
        OpenAPI()
            .info(
                Info()
                    .title("Kotlin Demo Project")
                    .version("1.0.0")
                    .description("Kotlin Demo Project description.")
            )
    }

    bean {
        val paths = arrayOf("/**")
        GroupedOpenApi.builder().group("All").pathsToMatch(*paths).build()
    }

}

