package net.bookmanager.domain.book

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class AuthorTest {

    @Test
    fun `1文字の場合作成可能`() {
        val input = "あ"
        val target = Author(input)
        assertEquals(target.value, input)
    }

    @Test
    fun `30文字の場合作成可能`() {
        val input = "ア".repeat(3000)
        val target = Author(input)
        assertEquals(target.value, input)
    }

    @Test
    fun `0文字の場合作成不可`() {
        val input = ""
        assertFailsWith<IllegalArgumentException> { Author(input) }
    }

    @Test
    fun `31文字の場合作成不可`() {
        val input = "あ".repeat(51)
        assertFailsWith<IllegalArgumentException> { Author(input) }
    }
}
