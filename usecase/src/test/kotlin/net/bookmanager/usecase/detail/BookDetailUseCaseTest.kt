package net.bookmanager.usecase.detail

import net.bookmanager.usecase.register.BookRegisterParam
import net.bookmanager.usecase.register.BookRegisterUseCase
import net.bookmanager.usecase.rental.BookRentalUseCase
import net.bookmanager.usecase.repository.BookTestRepository
import net.bookmanager.usecase.repository.RentalTestRepository
import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals

class BookDetailUseCaseTest {

    private val today = LocalDate.now()
    private val after7Days = LocalDate.now().plusDays(7)

    @Test
    fun `書籍ID=1がユーザID=1によってレンタル済みの場合、取得可能`() {
        // TODO 共通化したい
        // prepare
        val bookRepository = BookTestRepository()
        val bookRegister = BookRegisterUseCase(bookRepository)
        val params = BookRegisterParam(
            title = "ONE PIECE1巻",
            kanaTitle = "ワンピースイッカン",
            author = "尾田栄一郎",
            kanaAuthor = "オダエイイチロウ",
            releaseDate = LocalDate.of(1998, 1, 1)
        )
        bookRegister.register(params)
        val rentalRepository = RentalTestRepository()
        val renter = BookRentalUseCase(bookRepository, rentalRepository)
        renter.rental(1)

        // act
        val target = BookDetailUseCase(bookRepository, rentalRepository)
        val result = target.get(1)

        // assert
        assertEquals(1, result.id)
        assertEquals("ONE PIECE1巻", result.title)
        assertEquals("ワンピースイッカン", result.kanaTitle)
        assertEquals("尾田栄一郎", result.author)
        assertEquals("オダエイイチロウ", result.kanaAuthor)
        assertEquals(LocalDate.of(1998, 1, 1), result.releaseDate)
        assertEquals(1, result.rentalInfo?.userId)
        assertEquals(today, result.rentalInfo?.rentalDate)
        assertEquals(after7Days, result.rentalInfo?.returnDeadline)
    }

    @Test
    fun `書籍ID=1がレンタルされていない場合、取得可能`() {
        // TODO 共通化したい
        // prepare
        val bookRepository = BookTestRepository()
        val bookRegister = BookRegisterUseCase(bookRepository)
        val params = BookRegisterParam(
            title = "ONE PIECE1巻",
            kanaTitle = "ワンピースイッカン",
            author = "尾田栄一郎",
            kanaAuthor = "オダエイイチロウ",
            releaseDate = LocalDate.of(1998, 1, 1)
        )
        bookRegister.register(params)

        // act
        val rentalRepository = RentalTestRepository()
        val target = BookDetailUseCase(bookRepository, rentalRepository)
        val result = target.get(1)

        // assert
        assertEquals(1, result.id)
        assertEquals("ONE PIECE1巻", result.title)
        assertEquals("ワンピースイッカン", result.kanaTitle)
        assertEquals("尾田栄一郎", result.author)
        assertEquals("オダエイイチロウ", result.kanaAuthor)
        assertEquals(LocalDate.of(1998, 1, 1), result.releaseDate)
        assertEquals(null, result.rentalInfo)
    }
}
