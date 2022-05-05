package net.bookmanager.usecase.detail

import net.bookmanager.domain.BookExistenceCheck
import net.bookmanager.domain.book.IBookRepository
import net.bookmanager.domain.rental.IRentalRepository
import org.springframework.stereotype.Service

@Service
class BookDetailUseCase(
    private val bookRepository: IBookRepository,
    private val rentalRepository: IRentalRepository
) {
    fun get(bookId: Int): BookDetailResponse {
        // 本が登録済みかチェック
        val bookExistenceCheck = BookExistenceCheck(bookRepository)
        bookExistenceCheck.exists(bookId)

        // TODO bookの取得が2度手間になっている
        val book = bookRepository.findById(bookId)
        val rental = rentalRepository.findByBookId(bookId)
        // bookは存在チェック済みのため、!!として問題ないと判断
        // TODO この辺性能考えたい
        return BookDetailResponse(book!!, rental)
    }
}
