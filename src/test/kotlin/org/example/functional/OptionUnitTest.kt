package org.example.functional

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OptionUnitTest {

    @Test
    fun `should return the value given Some`() {
        val option = Option("some")
        val result = option.getOrElse(default = "ok")

        assertThat(result).isEqualTo("some")
    }

    @Test
    fun `should return default value given None`() {
        val nullValue: Any? = null
        val option = Option(value = nullValue)
        val result = option.getOrElse(default = "ok")

        assertThat(result).isEqualTo("ok")
    }

    @Test
    fun `should filter and return None`() {
        val option = Option(value = 100)
        val result = option.filter { it > 200 }

        assertThat(result).isEqualTo(Option.None)
    }

    @Test
    fun `should filter and return the same instance`() {
        val option = Option(value = 201)
        val result = option.filter { it > 200 }

        assertThat(result).isSameAs(option)
    }

    @Test
    fun `should map on Some instance`() {
        val option = Option(value = 201)
        val result = option.map { it * 2 }

        assertThat(result).isEqualTo(Option(402))
    }

    @Test
    fun `should map on None instance`() {
        val nullValue: Int? = null
        val option = Option(value = nullValue)
        val result = option.map { it * 2 }

        assertThat(result).isEqualTo(Option.None)
    }
}