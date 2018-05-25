package com.elastikafka.demo.entities

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document


@Document(indexName = "tweet", type = "tweet")

data class ElasticEntity(

              @Id
              var term:String?="",
              var id_user:Long?=0,
              var id_tweet:Long?=0,
              var text:String?="",
              var retweet_count:Int?=0,
              var address:String?="",
              var country:String?="",
              var  created_at:String?=""
)