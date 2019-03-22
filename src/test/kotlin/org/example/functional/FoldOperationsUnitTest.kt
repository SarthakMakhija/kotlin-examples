package org.example.functional

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FoldOperationsUnitTest {

    private val foldOperations = FoldOperations()

    @Test
    internal fun `should return indexes of Mississippi`() {
        val input = "Mississippi"
        val indexes = foldOperations.indexes(input)

        assertThat(indexes).isEqualTo(mapOf('M' to setOf(0),
                                            'i' to setOf(1, 4, 7, 10),
                                            's' to setOf(2, 3, 5, 6),
                                            'p' to setOf(8, 9)))
    }
}