package com.elastikafka.demo.repositories

import com.elastikafka.demo.entities.ElasticEntity
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository


interface TweetRepository: ElasticsearchRepository <ElasticEntity, String> {


    fun findByTerm(term: String): MutableList<ElasticEntity>


}