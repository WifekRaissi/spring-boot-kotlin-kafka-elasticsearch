package com.elastikafka.demo.services


import com.elastikafka.demo.entities.ElasticEntity
import com.elastikafka.demo.entities.Tweet
import com.elastikafka.demo.repositories.TweetRepository
import org.springframework.stereotype.Service
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.annotation.StreamListener


@Service

open class TwitterServiceImpl:TwitterService{
    val JSON = jacksonObjectMapper()


    private val logger = LoggerFactory.getLogger(TwitterService::class.java)


    @Autowired
    lateinit var tweetRepository: TweetRepository


    @StreamListener("input")
    override fun receiveTweet(tweetString: ByteArray) {
        logger.info("recieved tweet")

        val parsedMessage = JSON.readValue(tweetString, String::class.java)
        val tweet = JSON.readValue(parsedMessage, Tweet::class.java)

        logger.info("$tweet")


       val list = tweet.statuses

        for (f in list) {
            logger.info("$f.coordinates")
            val tweet2 = ElasticEntity(tweet.term, f.user?.id, f.id, f.text, f.retweet_count, f.place?.full_name, f.place?.country, f.created_at)
            logger.info("$tweet2")
            logger.info("now we are starting elasticsearch!!!!!!!!!!!!!!!!!!!!!!!!")

            tweetRepository.save(tweet2)

            tweetRepository.index(tweet2)
            logger.info("$tweet2")
            logger.info("your tweets have been indexed successfully ")
        }

    }}




