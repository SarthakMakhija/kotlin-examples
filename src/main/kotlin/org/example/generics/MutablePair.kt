package org.example.generics

class MutablePair<T : Any>(private var first: T, private var second: T) {

    fun swap(): MutablePair<T> {
        return this.apply {
            val secondCopy = this.second
            this.second    = this.first
            this.first     = secondCopy
        }
    }

    override fun equals(other: Any?): Boolean {
        return when (other) {
            is MutablePair<*> -> this.first == other.first && this.second == other.second
            else              -> false
        }
    }

    override fun hashCode(): Int {
        return 31 * first.hashCode() + second.hashCode()
    }
}