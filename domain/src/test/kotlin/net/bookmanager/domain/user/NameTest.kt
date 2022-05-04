package net.bookmanager.domain.user

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class NameTest {

    @Test
    fun `1文字の場合作成できる`() {
        val target = Name("あ")
        assertEquals("あ", target.value)
    }

    @Test
    fun `20文字の場合作成できる`() {
        val target = Name("あ".repeat(20))
        assertEquals("あ".repeat(20), target.value)
    }

    @Test
    fun `0文字の場合作成できない`() {
        assertFailsWith<IllegalArgumentException> { Name("") }
    }

    @Test
    fun `21文字の場合作成できない`() {
        assertFailsWith<IllegalArgumentException> { Name("あ".repeat(21)) }
    }
}
