package com.example.requestwithfeignclient.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "translationApiClient", url="https://product-international-content-api-service.stage.trendyol.com")
interface TranslationApiClient {

    @PostMapping(value = ["/productContents/reindex/{id}"])
    public fun reindex(@PathVariable id:Long,@RequestParam language:String)
}

//bean olarak service ekledik. bir class ı bean olarak tanımlıyoruz. daha sonra bu classı inject ederek istedigimiz yerde cagırabiliriz.