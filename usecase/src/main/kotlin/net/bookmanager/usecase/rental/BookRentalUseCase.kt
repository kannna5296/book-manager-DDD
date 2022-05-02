package net.bookmanager.usecase.rental

import net.bookmanager.domain.rental.IRentalRepository
import net.bookmanager.domain.rental.Rental
import org.springframework.stereotype.Service

@Service
class BookRentalUseCase(
    private val rentalRepository: IRentalRepository
) {
    fun rental(bookId: Int): BookRentalResponse {
        val rental = Rental.create(
            //TODO　ログイン周り整ったらuserIdは追加
            userId = 1,
            bookId = bookId
        )
        val createdRental = rentalRepository.insert(rental)
        return BookRentalResponse(createdRental)
    }

}
