package com.example.requestwithfeignclient.entity

import lombok.*
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import java.util.*

@Document(indexName = "kisiler")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Kisi {
    @Id
    var id: String? = null

    @Field(name = "ad", type = FieldType.Text)
    var ad: String? = null

    @Field(name = "soyad", type = FieldType.Text)
    var soyad: String? = null

    @Field(name = "adres", type = FieldType.Text)
    var adres: String? = null

    @Field(name = "dogum_tarihi", type = FieldType.Date)
    var dogumTarihi: Date? = null
}