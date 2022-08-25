package com.example.requestwithfeignclient.controller

import io.swagger.v3.oas.annotations.Hidden
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/")
class IndexController {

    @Hidden
    @GetMapping
    fun redirectToSwaggerUi(exchange: ServerWebExchange): Mono<Void> {
        val response: ServerHttpResponse = exchange.response
        response.statusCode = HttpStatus.PERMANENT_REDIRECT
        response.headers.add(HttpHeaders.LOCATION, "/swagger-ui.html")
        return response.setComplete()
    }

    @Hidden
    @GetMapping("swagger-ui")
    fun redirectToSwagger(exchange: ServerWebExchange): Mono<Void> {
        val response: ServerHttpResponse = exchange.response
        response.statusCode = HttpStatus.PERMANENT_REDIRECT
        response.headers.add(HttpHeaders.LOCATION, "/swagger-ui.html")
        return response.setComplete()
    }
}
