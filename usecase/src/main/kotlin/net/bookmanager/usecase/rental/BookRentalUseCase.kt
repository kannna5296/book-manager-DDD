package net.bookmanager.usecase.rental

import net.bookmanager.domain.AlreadyRentalCheck
import net.bookmanager.domain.BookExistenceCheck
import net.bookmanager.domain.book.IBookRepository
import net.bookmanager.domain.rental.IRentalRepository
import net.bookmanager.domain.rental.Rental
import org.springframework.stereotype.Service

@Service
class BookRentalUseCase(
    private val bookRepository: IBookRepository,
    private val rentalRepository: IRentalRepository
) {
    fun rental(bookId: Int): BookRentalResponse {
        // 本が登録済みかチェック
        val bookExistenceCheck = BookExistenceCheck(bookRepository)
        bookExistenceCheck.exists(bookId)

        // すでにレンタルされていないかチェック
        val alreadyRentalCheck = AlreadyRentalCheck(rentalRepository)
        alreadyRentalCheck.isAvailable(bookId)

        val rental = Rental.create(
            // TODO　ログイン周り整ったらuserIdは追加
            userId = 1,
            bookId = bookId
        )
        val createdRental = rentalRepository.insert(rental)
        return BookRentalResponse(createdRental)
    }
}
