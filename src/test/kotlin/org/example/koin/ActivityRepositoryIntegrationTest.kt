package org.example.koin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ActivityRepositoryIntegrationTest : KoinTest {

    @BeforeAll
    fun setUp() {
        startKoin {
            modules(module {
                single { ActivityRepository() }
            })
        }
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