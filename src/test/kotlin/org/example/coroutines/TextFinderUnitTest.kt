package org.example.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TextFinderUnitTest {

    @Test
    fun `should find text in all sources`() {
        val sourcePaths = listOf("content1.txt", "content2.txt", "content3.txt", "content4.txt")
        val textFinderAggregate = TextFinderAggregate(sourcePaths)

        val sources = runBlocking {
            textFinderAggregate.findTextSources("Lorem", dispatcher = Dispatchers.Default)
        }

        assertThat(sources).isEqualTo(sourcePaths)
    }

    @Test
    fun `should find text in all sources given coroutine is launched in main thread`() {
        val sourcePaths = listOf("content1.txt", "content2.txt", "content3.txt", "content4.txt")
        val textFinderAggregate = TextFinderAggregate(sourcePaths)

        val sources = runBlocking {
            textFinderAggregate.findTextSources("Lorem")
        }

        assertThat(sources).isEqualTo(sourcePaths)
    }

    @Test
    fun `should find text in no sources`() {
        val sourcePaths = listOf("content1.txt", "content2.txt", "content3.txt", "content4.txt")
        val textFinderAggregate = TextFinderAggregate(sourcePaths)

        val sources = runBlocking {
            textFinderAggregate.findTextSources("kotlin", dispatcher = Dispatchers.Default)
        }

        assertThat(sources).isEmpty()
    }
}