package net.bookmanager.domain.book

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TitleTest{

    @Test
    fun `1文字の場合作成可能`(){
        val input = "あ"
        val target = Title(input)
        assertEquals(target.value, input)
    }

    @Test
    fun `30文字の場合作成可能`(){
        val input = "ア".repeat(30)
        val target = Title(input)
        assertEquals(target.value, input)
    }

    @Test
    fun `0文字の場合作成不可`(){
        val input = ""
        assertFailsWith<IllegalArgumentException> {  Title(input) }
    }

    @Test
    fun `31文字の場合作成不可`(){
        val input = "あ".repeat(51)
        assertFailsWith<IllegalArgumentException> {  Title(input) }
    }
}