package com.elastikafka.demo.entities

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldIndex.not_analyzed


@Document(indexName = "tweetsbyterm", type = "tweets")
data class ElasticEntity(


              @Id
              var term:String?="",
              var id_user:Long?=0,
              var id_tweet:Long?=0,
              @Field(index = not_analyzed)
              var text:String?="",
              var retweet_count:Int?=0,
              @Field(index = not_analyzed)
              var address:String?="",
              @Field(index = not_analyzed)
              var country:String?="",
              @Field(index = not_analyzed)
              var  created_at:String?=""


 )