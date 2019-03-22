package org.example.functional

sealed class Option<out T> {

    fun getOrElse(default: @UnsafeVariance T): T {
        return when (this) {
            is None -> default
            is Some -> value
        }
    }

    fun filter(predicate: (T) ->  Boolean) : Option<T> {
        return when(this) {
            is None -> None
            is Some -> if ( predicate(value) ) this else None
        }
    }

    fun <R> map(fn: (T) -> (R)) : Option<R> {
        return when(this) {
            is Some -> Some(fn(value))
            is None -> None
        }
    }

    class Some<T>(val value: T) : Option<T>() {

        override fun equals(other: Any?): Boolean {
            return when(other) {
                is Some<*> -> this.value == other.value
                else       -> false
            }
        }

        override fun hashCode(): Int {
            return value?.hashCode() ?: 0
        }
    }

    object None : Option<Nothing>()

    companion object {
        operator fun <T> invoke(value: T?): Option<T> {
            return when (value) {
                null -> None
                else -> Some(value)
            }
        }
    }
}