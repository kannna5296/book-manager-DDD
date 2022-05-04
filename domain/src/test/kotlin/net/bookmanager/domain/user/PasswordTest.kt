package net.bookmanager.domain.user

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class PasswordTest {

    @Test
    fun `8文字は作成できる`() {
        val input = "a".repeat(8)
        val target = Password(input)
        assertEquals(input, target.value)
    }

    @Test
    fun `7文字は作成できない`() {
        val input = "a".repeat(7)
        assertFailsWith<IllegalArgumentException> { Password(input) }
    }

    @Test
    fun `20文字は作成できる`() {
        val input = "a".repeat(20)
        val target = Password(input)
        assertEquals(input, target.value)
    }

    @Test
    fun `21文字は作成できない`() {
        val input = "a".repeat(21)
        assertFailsWith<IllegalArgumentException> { Password(input) }
    }

    @Test
    fun `数字のみは作成できる`() {
        val input = "12345678"
        val target = Password(input)
        assertEquals(input, target.value)
    }

    @Test
    fun `英語のみは作成できる`() {
        val input = "mushroom"
        val target = Password(input)
        assertEquals(input, target.value)
    }

    @Test
    fun `数字英語混じりは作成できる`() {
        val input = "12345678mushroom"
        val target = Password(input)
        assertEquals(input, target.value)
    }

    @Test
    fun `記号ありは作成できない`() {
        val input = "password&"
        assertFailsWith<IllegalArgumentException> { Password(input) }
    }
}
