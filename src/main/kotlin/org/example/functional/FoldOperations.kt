package org.example.functional

class FoldOperations {

    fun indexes(input: String) : Map<Char, Set<Int>> {
        return input.foldIndexed(
                          initial   = mapOf(),
                          operation = {
                              index, map, char -> map + (char to map.getOrDefault(char, setOf()) + index)
                          }
                    )
    }
}