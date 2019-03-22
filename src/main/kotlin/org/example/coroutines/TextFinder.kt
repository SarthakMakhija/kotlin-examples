package org.example.coroutines

import kotlinx.coroutines.*
import java.io.File

class TextFinder(private val sourcePath: String) {

    private val ioThreadPoolContext = Dispatchers.IO

    suspend fun isTextPresent(text: String): Boolean {
        return withContext(ioThreadPoolContext) {
            val classloader = Thread.currentThread().contextClassLoader
            val file = File(classloader.getResource(sourcePath).file)

            println("finding $text in $sourcePath using ${Thread.currentThread().name}")
            file.readLines().count { it.contains(text) } > 0
        }
    }
}

class TextFinderAggregate(private val sourcePaths: List<String>) {

    suspend fun findTextSources(query: String, dispatcher: CoroutineDispatcher): List<String> {
        return coroutineScope {
            sourcePaths
                .map { filePath ->
                    Pair(filePath,
                        async(dispatcher) {
                            println("Running TextFinder in ${Thread.currentThread().name} for $filePath")
                            TextFinder(filePath).isTextPresent(query)
                        })
                }
                .filter { pair ->
                    pair.second.await()
                }
                .map { pair ->
                    pair.first
                }
        }
    }
}