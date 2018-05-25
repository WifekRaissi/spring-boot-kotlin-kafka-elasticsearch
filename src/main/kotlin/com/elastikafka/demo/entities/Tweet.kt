package com.elastikafka.demo.entities

import java.util.ArrayList

data class Tweet (

        val term:String?,
        val statuses: ArrayList<Statuses>,
        val search_metadata:Search_metadata

)