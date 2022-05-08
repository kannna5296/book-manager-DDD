package net.bookmanager.usecase.search

import net.bookmanager.domain.book.IBookRepository
import org.springframework.stereotype.Service

@Service
class BookSearchUseCase(
    private val bookRepository: IBookRepository
) {
    fun search(form: SearchForm): List<BookSearchResponse> {
        val result = bookRepository.search(form.kanaTitle, form.kanaAuthor, form.isRental)
        return result.map {
            (BookSearchResponse(it))
        }
    }
}
