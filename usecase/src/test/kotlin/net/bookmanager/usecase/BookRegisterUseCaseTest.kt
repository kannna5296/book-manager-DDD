package net.bookmanager.usecase

import net.bookmanager.usecase.register.BookRegisterParam
import net.bookmanager.usecase.register.BookRegisterUseCase
import net.bookmanager.usecase.repository.BookTestRepository
import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class BookRegisterUseCaseTest{

    @Test
    fun `登録可能`(){
        val bookRepository = BookTestRepository()
        val target = BookRegisterUseCase(bookRepository)
        val params = BookRegisterParam(
            title = "ONE PIECE1巻",
            kanaTitle = "ワンピースイッカン",
            author = "尾田栄一郎",
            kanaAuthor = "オダエイイチロウ",
            //多分嘘
            releaseDate = LocalDate.of(1998,1,1)
        )
        target.register(params)
        val result = bookRepository.findById(1) ?: fail("resultが取得できませんでした")
        assertEquals("ONE PIECE1巻",result.title.value)
        assertEquals("ワンピースイッカン",result.kanaTitle.value)
        assertEquals("尾田栄一郎",result.author.value)
        assertEquals("オダエイイチロウ",result.kanaAuthor.value)
        assertEquals(LocalDate.of(1998,1,1),result.releaseDate.value)
    }
}