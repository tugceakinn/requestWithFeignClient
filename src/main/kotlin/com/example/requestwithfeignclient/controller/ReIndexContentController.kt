package com.example.requestwithfeignclient.controller

import com.example.requestwithfeignclient.client.TranslationApiClient
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/reindex-content")
class ReIndexContentController(val translationApiClient: TranslationApiClient) {

        @PostMapping("{id}")
         fun reIndex(@PathVariable id: Long, @RequestParam language: Language): Boolean {
            translationApiClient.reindex(11153899,"DE")
            return true
        }
}

enum class Language{
        EN,
        DE
}

//dependency injection TranslationApiClient'ı controllarda kullanabilmek için içine ekledik->class com.example.requestwithfeignclient.controller.ReIndexContentController(private val translationApiClient: TranslationApiClient)
//1.swagger
//2.birden fazla content içi istek atılabilecek
//bu istekler paralel olucak