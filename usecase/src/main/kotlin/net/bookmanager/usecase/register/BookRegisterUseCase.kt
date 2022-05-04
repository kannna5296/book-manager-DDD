package net.bookmanager.usecase.register

import net.bookmanager.domain.book.Title
import net.bookmanager.domain.book.KanaTitle
import net.bookmanager.domain.book.Author
import net.bookmanager.domain.book.KanaAuthor
import net.bookmanager.domain.book.ReleaseDate
import net.bookmanager.domain.book.Book
import net.bookmanager.domain.book.IBookRepository
import org.springframework.stereotype.Service

@Service
class BookRegisterUseCase(
    private val bookRepository: IBookRepository
) {
    fun register(param: BookRegisterParam): BookRegisterResponse {
        val book = Book(
            title = Title(param.title),
            kanaTitle = KanaTitle(param.kanaTitle),
            author = Author(param.author),
            kanaAuthor = KanaAuthor(param.kanaAuthor),
            releaseDate = ReleaseDate(param.releaseDate)
        )
        val createdBook = bookRepository.insert(book)
        return BookRegisterResponse(createdBook)
    }
}