package net.bookmanager.domain.book

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class KanaAuthorTest{

    @Test
    fun `全部カナかつ1文字の場合作成可能`(){
        val input = "ア"
        val target = KanaAuthor(input)
        assertEquals(target.value, input)
    }

    @Test
    fun `全部カナかつ50文字の場合作成可能`(){
        val input = "ア".repeat(50)
        val target = KanaAuthor(input)
        assertEquals(target.value, input)
    }

    @Test
    fun `0文字の場合作成不可`(){
        val input = ""
        assertFailsWith<IllegalArgumentException> {  KanaAuthor(input) }
    }

    @Test
    fun `全部カナかつ51文字の場合作成不可`(){
        val input = "ア".repeat(51)
        assertFailsWith<IllegalArgumentException> {  KanaAuthor(input) }
    }

    @Test
    fun `カナ以外が含まれる場合作成不可`(){
        val input = "アあ"
        assertFailsWith<IllegalArgumentException> {  KanaAuthor(input) }
    }
}