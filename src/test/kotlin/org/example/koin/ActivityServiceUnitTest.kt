package org.example.koin

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class ActivityServiceUnitTest {

    private val activityRepository = mockk<ActivityRepository>(relaxed = true)

    private val activityService = ActivityService(activityRepository)

    @Test
    fun `should invoke repository to add an activity`() {
        val activity = Activity(description = "running")
        activityService.add(activity)

        verify { activityRepository.add(activity) }
    }

    @Test
    fun `should invoke repository to delete an activity by id`() {
        activityService.deleteById(id = "120")

        verify { activityRepository.deleteById("120") }
    }

    @Test
    fun `should invoke repository to find an activity by id`() {
        activityService.findById(id = "120")

        verify { activityRepository.findById("120") }
    }
}