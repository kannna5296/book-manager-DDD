package net.bookmanager.usecase.search

import net.bookmanager.domain.book.Book
import net.bookmanager.domain.rental.Rental
import java.time.LocalDate

class BookSearchResponse(
    val id: Int?,
    val title: String,
    val kanaTitle: String,
    val author: String,
    val kanaAuthor: String,
    val releaseDate: LocalDate,
    val isRental: Boolean
) {
    constructor(book: Book, rental: Rental?) : this(
        id = book.id,
        title = book.title.value,
        kanaTitle = book.kanaTitle.value,
        author = book.author.value,
        kanaAuthor = book.kanaAuthor.value,
        releaseDate = book.releaseDate.value,
        //本に紐づくRental情報があればRentalされているとして修正
        isRental = rental != null
    )
}
