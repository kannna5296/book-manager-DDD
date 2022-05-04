package net.bookmanager.usecase.rental

import net.bookmanager.usecase.register.BookRegisterParam
import net.bookmanager.usecase.register.BookRegisterUseCase
import net.bookmanager.usecase.repository.BookTestRepository
import net.bookmanager.usecase.repository.RentalTestRepository
import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class BookRentalUseCaseTest {

    private val today = LocalDate.now()
    private val after7Days = LocalDate.now().plusDays(7)

    @Test
    fun `書籍ID=1がすでに登録済みの場合、書籍ID=1の書籍をレンタル可能`() {
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
        val target = BookRentalUseCase(bookRepository, rentalRepository)
        target.rental(1)

        // assert
        val result = rentalRepository.findById(1) ?: kotlin.test.fail("resultが取得できませんでした")
        assertEquals(1, result.bookId.value)
        assertEquals(1, result.userId.value)
        assertEquals(today, result.rentalDate.value)
        assertEquals(after7Days, result.returnDeadline.value)
    }

    @Test
    fun `書籍ID=1が登録済みでない場合、書籍ID=1の書籍をレンタル不可`() {
        val bookRepository = BookTestRepository()
        val rentalRepository = RentalTestRepository()
        val target = BookRentalUseCase(bookRepository, rentalRepository)

        // act,assert
        assertFailsWith<IllegalStateException> { target.rental(1) }
    }

    @Test
    fun `書籍ID=1が既にレンタルされている場合、書籍ID=1の書籍をレンタル不可`() {
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
        val target = BookRentalUseCase(bookRepository, rentalRepository)
        target.rental(1)

        // act,assert
        assertFailsWith<IllegalStateException> { target.rental(1) }
    }
}
