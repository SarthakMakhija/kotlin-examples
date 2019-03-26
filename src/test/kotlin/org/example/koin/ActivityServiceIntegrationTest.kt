package org.example.koin

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject

class ActivityServiceIntegrationTest : KoinTest {

    @BeforeEach
    fun setUp() {
        startKoin {
            modules(module {
                single { ActivityRepository() }
                single { ActivityService(get()) }
            })
        }
    }

    @AfterEach
    fun tearDown() {
        GlobalContext.stop()
    }

    private val activityService : ActivityService by inject()

    @Test
    fun `should add an activity`() {
        val activityId = activityService.add(Activity(description = "running"))
        val activity   = activityService.findById(activityId)

        Assertions.assertThat(activity!!.description).isEqualTo("running")
    }

    @Test
    fun `should find an activity by id`() {
        val activityId = activityService.add(Activity(description = "reading"))
        val activity   = activityService.findById(activityId)

        Assertions.assertThat(activity!!.description).isEqualTo("reading")
    }

    @Test
    fun `should remove activity by id`() {
        val activityId = activityService.add(Activity(description = "playing"))
        activityService.deleteById(activityId)
        val activity = activityService.findById(activityId)

        Assertions.assertThat(activity).isNull()
    }
}