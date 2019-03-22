package org.example.generics

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MutablePairUnitTest {

    @Test
    fun `should swap the pair elements of mutable pair`() {
        val pair = MutablePair("one", "single")
        val swapped = pair.swap()

        assertThat(swapped).isEqualTo(MutablePair("single", "one"))
    }
}