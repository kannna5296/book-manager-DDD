package net.bookmanager.domain.user

import kotlin.test.Test
import kotlin.test.assertEquals

class EmailTest{

    @Test
    fun `通常メールアドレスなら作成可能`(){
        val input = "someone@gmail.com"
        val target = Email(input)
        assertEquals(target.value, input)
    }

    @Test
    fun `@以下ドットなし_作成不可`(){
        val input = "someone@com"
        val target = Email(input)
        assertEquals(target.value, input)
    }

    @Test
    fun `@以下なし`(){
        val input = "someone@"
        val target = Email(input)
        assertEquals(target.value, input)
    }

    @Test
    fun `@始まり`(){
        val input = "@gmail.com"
        val target = Email(input)
        assertEquals(target.value, input)
    }
}