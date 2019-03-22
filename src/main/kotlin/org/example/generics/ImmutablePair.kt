package org.example.generics

class ImmutablePair<out T : Any, out S : Any>(private val first: T, private val second: S) {

    fun swap(): ImmutablePair<S, T> {
        return ImmutablePair(this.second, this.first)
    }

    override fun equals(other: Any?): Boolean {
        return when (other) {
            is ImmutablePair<*, *> -> this.first == other.first && this.second == other.second
            else                   -> false
        }
    }

    override fun hashCode(): Int {
        return 31 * first.hashCode() + second.hashCode()
    }
}