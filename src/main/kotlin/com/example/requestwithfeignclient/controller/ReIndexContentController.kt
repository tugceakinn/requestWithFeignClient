package com.example.requestwithfeignclient.controller

import com.example.requestwithfeignclient.client.TranslationApiClient
import com.example.requestwithfeignclient.models.ReIndexResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/reindex-content")
class ReIndexContentController(val translationApiClient: TranslationApiClient) {

        @PostMapping()
         fun reIndex(@RequestParam ids: Set<Long>, @RequestParam language: Language): ReIndexResponse {
            ids.parallelStream().forEach{
                translationApiClient.reindex(it,language.name)
            }
           return ReIndexResponse("reindex başarılı")

        }
}

enum class Language{
        EN,
        DE
}

//enum oldugu için language.name diyerek ulaştık
//dependency injection TranslationApiClient'ı controllarda kullanabilmek için içine ekledik->class com.example.requestwithfeignclient.controller.ReIndexContentController(private val translationApiClient: TranslationApiClient)
//1.swagger done
//2.birden fazla content içi istek atılabilecek done
//bu istekler paralel olucak done