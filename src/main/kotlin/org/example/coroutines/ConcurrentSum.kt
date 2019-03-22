package org.example.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class IntProducer(private val totalElements: Int) {

    fun ints(): List<Int> {
        val elements = mutableListOf<Int>()
        repeat(totalElements) { e ->
            elements += e
        }
        return elements.toList()
    }
}

class AggregateSum(
    private val intProducer: IntProducer,
    private val chunkSize: Int
) {

    suspend fun sum(dispatcher: CoroutineDispatcher): Long {
        val chunks: List<List<Int>> = intProducer.ints().chunked(size = chunkSize)

        return coroutineScope {
            chunks
                .map { chunk ->
                    async(dispatcher) {
                        println("Running ${Thread.currentThread().name}")
                        sum(chunk)
                    }
                }
                .map {
                    it.await()
                }
                .sum()
        }
    }

    fun sum(elements: List<Int>): Long = elements.sum().toLong()
}