package org.example.extension

class Fraction(private val numerator: Int, private val denominator: Int) {

    operator fun plus(that: Fraction): Fraction =
        Fraction(
            numerator = this.numerator * that.denominator + this.denominator * that.numerator,
            denominator = this.denominator * that.denominator
        )

    override fun toString(): String = "n/d = $numerator/$denominator"

    override fun equals(other: Any?): Boolean {
        return when (other) {
            is Fraction -> this.numerator == other.numerator && this.denominator == other.denominator
            else        -> false
        }
    }

    override fun hashCode(): Int {
        return 31 * numerator + denominator
    }
}