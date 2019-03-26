package org.example.koin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject

class ActivityRepositoryIntegrationTest : KoinTest {

    @BeforeEach
    fun setUp() {
        startKoin {
            modules(module {
                single { ActivityRepository() }
            })
        }
    }

    @AfterEach
    fun tearDown() {
        GlobalContext.stop()
    }

    private val activityRepository : ActivityRepository by inject()

    @Test
    fun `should add an activity`() {
        val activityId = activityRepository.add(Activity(description = "running"))
        val activity   = activityRepository.findById(activityId)

        assertThat(activity!!.description).isEqualTo("running")
    }

    @Test
    fun `should find an activity by id`() {
        val activityId = activityRepository.add(Activity(description = "reading"))
        val activity   = activityRepository.findById(activityId)

        assertThat(activity!!.description).isEqualTo("reading")
    }

    @Test
    fun `should remove activity by id`() {
        val activityId = activityRepository.add(Activity(description = "playing"))
        activityRepository.deleteById(activityId)
        val activity = activityRepository.findById(activityId)

        assertThat(activity).isNull()
    }
}