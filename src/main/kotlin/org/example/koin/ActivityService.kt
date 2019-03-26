package org.example.koin

class ActivityService(private val activityRepository: ActivityRepository) {

    fun add(activity: Activity): String = activityRepository.add(activity)

    fun deleteById(id: String) {
        activityRepository.deleteById(id)
    }

    fun findById(id: String) = activityRepository.findById(id)
}