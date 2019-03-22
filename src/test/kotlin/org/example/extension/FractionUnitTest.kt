package org.example.extension

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FractionUnitTest {

    @Test
    fun `should add 2 non trivial fractions`() {
        val fraction1 = Fraction(1, 2)
        val fraction2 = Fraction(1, 3)

        val sum = fraction1 + fraction2
        assertThat(sum).isEqualTo(Fraction(5, 6))
    }

    @Test
    fun `should add 2 fractions with same denominator without reduction`() {
        val fraction1 = Fraction(1, 3)
        val fraction2 = Fraction(1, 3)

        val sum = fraction1 + fraction2
        assertThat(sum).isEqualTo(Fraction(6, 9))
    }

    @Test
    fun `should add an integer to a fraction`() {
        val fraction = Fraction(1, 3)

        val sum = 3.toFraction() + fraction
        assertThat(sum).isEqualTo(Fraction(10, 3))
    }
}