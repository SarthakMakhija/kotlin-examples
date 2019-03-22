package org.example.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AggregateSumUnitTest {

    @Test
    fun `should return sum of 100 elements with chunk size 10`() {
        val aggregateSum = AggregateSum(IntProducer(totalElements = 100), chunkSize = 10)
        val output = runBlocking {
            aggregateSum.sum(dispatcher = Dispatchers.Default)
        }

        assertThat(output).isEqualTo(4950)
    }
}
