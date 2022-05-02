package net.bookmanager.infra.entity

import net.bookmanager.domain.book.*
import java.time.LocalDate

class BookEntity(
    var id: Int? = null,
    var title: String? = null,
    var kanaTitle: String? = null,
    var author: String? = null,
    var kanaAuthor: String? = null,
    var releaseDate: LocalDate? = null
){
    constructor(book: Book) : this(
        title = book.title.value,
        kanaTitle = book.kanaTitle.value,
        author = book.author.value,
        kanaAuthor = book.kanaAuthor.value,
        releaseDate = book.releaseDate.value
    )

    fun toDomainModel(): Book {
        return Book(
            id = id,
            //DBに変な値が入ってた時はNG
            title = Title(title ?: throw IllegalStateException("")),
            kanaTitle = KanaTitle(kanaTitle ?: throw IllegalStateException("")),
            author = Author(author ?: throw IllegalStateException("")),
            kanaAuthor = KanaAuthor(kanaTitle ?: throw IllegalStateException("")),
            releaseDate = ReleaseDate(releaseDate ?: throw IllegalStateException("")),
        )
    }
}