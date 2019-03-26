package org.example.koin

import java.util.*

class ActivityRepository {

    private val activities = mutableMapOf<String, Activity>()

    fun add(activity: Activity): String {
        val id = UUID.randomUUID().toString()
        activities += id to activity

        return id
    }

    fun findById(id: String): Activity? = activities[id]

    fun deleteById(id: String) {
        activities -= (id)
    }
}