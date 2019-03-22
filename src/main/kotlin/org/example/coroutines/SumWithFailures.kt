package org.example.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

class SumWithFailures(private val elements: List<Int?>, private val chunkSize: Int) {

    suspend fun sum(dispatcher: CoroutineDispatcher): Long {
        val chunks = elements.chunked(size = chunkSize)

        return coroutineScope {
            withContext(dispatcher) {
                chunks
                    .map { chunk ->
                        async {
                            println("Running ${Thread.currentThread().name}")
                            sum(chunk)
                        }
                    }
                    .map { it.await() }
                    .sum()
            }
        }
    }

    private fun sum(elements: List<Int?>): Long {
        return if (elements.contains(null)) throw RuntimeException("null found")
        else elements.filterNotNull().sum().toLong()
    }
}