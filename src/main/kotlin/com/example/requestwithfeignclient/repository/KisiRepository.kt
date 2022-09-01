package com.example.requestwithfeignclient.repository

import com.example.requestwithfeignclient.entity.Kisi
import org.springframework.data.elasticsearch.annotations.Query
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository

@Repository
interface KisiRepository : ElasticsearchRepository<Kisi, String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"ad\": \"?0\"}}]}}")
    fun getByCustomQuery(search: String): List<Kisi>
}