package net.bookmanager.usecase.search

import net.bookmanager.domain.book.IBookRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookSearchUseCase(
    private val bookRepository: IBookRepository
) {
    fun search(form: SearchForm, pageable: Pageable): List<BookSearchResponse> {
        val result = bookRepository.search(form.kanaTitle, form.kanaAuthor, form.isRental, pageable)
        return result.map {
            (BookSearchResponse(it))
        }
    }
}
