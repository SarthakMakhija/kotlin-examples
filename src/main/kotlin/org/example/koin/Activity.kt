package org.example.koin

import java.time.ZoneId
import java.time.ZonedDateTime

class Activity(val description: String, private val time: ZonedDateTime = ZonedDateTime.now(ZoneId.of("UTC"))) {

    override fun toString(): String {
        return "Activity(description='$description', time=$time)"
    }
}
