package net.bookmanager.usecase.detail

import net.bookmanager.domain.book.Book
import net.bookmanager.domain.rental.Rental
import java.time.LocalDate

class BookDetailResponse(
    val id: Int?,
    val title: String,
    val kanaTitle: String,
    val author: String,
    val kanaAuthor: String,
    val releaseDate: LocalDate,
    val rentalInfo: RentalInfo?
) {
    constructor(book: Book, rental: Rental?) : this(
        id = book.id,
        title = book.title.value,
        kanaTitle = book.kanaTitle.value,
        author = book.author.value,
        kanaAuthor = book.kanaAuthor.value,
        releaseDate = book.releaseDate.value,
        rentalInfo = rental?.let { RentalInfo(it) }
    )
}

class RentalInfo(
    val userId: Int,
    val rentalDate: LocalDate,
    val returnDeadline: LocalDate
) {
    constructor(rental: Rental) : this(
        userId = rental.userId,
        rentalDate = rental.rentalDate.value,
        returnDeadline = rental.returnDeadline.value
    )
}
