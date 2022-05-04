package net.bookmanager.usecase.register

import net.bookmanager.domain.book.Book
import java.time.LocalDate

class BookRegisterResponse(
    val id: Int?,
    val title: String,
    val kanaTitle: String,
    val author: String,
    val kanaAuthor: String,
    val releaseDate: LocalDate
) {
    constructor(book: Book) : this(
        id = book.id,
        title = book.title.value,
        kanaTitle = book.kanaTitle.value,
        author = book.author.value,
        kanaAuthor = book.kanaAuthor.value,
        releaseDate = book.releaseDate.value
    )
}
