package com.elastikafka.demo.services

import org.springframework.cloud.stream.annotation.StreamListener


interface TwitterService{


    @StreamListener(value = "input")
    fun receiveTweet(tweetString: ByteArray)


}