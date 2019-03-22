package org.example.generics

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ImmutablePairUnitTest {

    @Test
    fun `should swap pair elements and return a new pair`() {
        val pair    = ImmutablePair("one", 1)
        val swapped = pair.swap()

        assertThat(swapped).isEqualTo(ImmutablePair(1, "one"))
    }
}