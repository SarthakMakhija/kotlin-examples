package org.example.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class SumWithFailuresUnitTest {

    @Test
    fun `should return sum of 10 elements with chunk size 2`() {
        val sumWithFailures = SumWithFailures(elements = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), chunkSize = 2)
        val output = runBlocking { sumWithFailures.sum(Dispatchers.Default) }

        assertThat(output).isEqualTo(55)
    }

    @Test
    fun `should fail given list contains null`() {
        val sumWithFailures = SumWithFailures(elements = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, null), chunkSize = 2)
        assertThrows<RuntimeException> {
            runBlocking { sumWithFailures.sum(Dispatchers.Default) }
        }
    }
}