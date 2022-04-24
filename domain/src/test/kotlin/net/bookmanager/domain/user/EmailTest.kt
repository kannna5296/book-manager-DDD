package net.bookmanager.domain.user

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

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
        assertFailsWith<IllegalArgumentException> { Email(input) }
    }

    @Test
    fun `@以下なし_作成不可`(){
        val input = "someone@"
        assertFailsWith<IllegalArgumentException> { Email(input) }
    }

    @Test
    fun `@始まり_作成不可`(){
        val input = "@gmail.com"
        assertFailsWith<IllegalArgumentException> { Email(input) }
    }
}