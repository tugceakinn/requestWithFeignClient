package com.example.requestwithfeignclient.controller

import com.example.requestwithfeignclient.entity.Kisi
import com.example.requestwithfeignclient.repository.KisiRepository
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.annotation.PostConstruct


@RequiredArgsConstructor
@RestController
@RequestMapping("/kisi")
class KisiController(val kisiRepository: KisiRepository) {

    @PostConstruct
    fun init() {
        val kisi = Kisi()
        kisi.ad="tugce"
        kisi.soyad="akin"
        kisi.adres="123"
        kisi.dogumTarihi= Calendar.getInstance().time
        kisi.id="4"
        kisiRepository.save(kisi)
    }

    @GetMapping("/{search}")
    fun getKisi(@PathVariable search:String):ResponseEntity<List<Kisi>> {
                val kisiler :List<Kisi> = kisiRepository.getByCustomQuery(search)
        return ResponseEntity.ok(kisiler)
    }
}