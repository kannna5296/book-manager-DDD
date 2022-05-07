package net.bookmanager.usecase.search

import net.bookmanager.domain.book.IBookRepository
import org.springframework.stereotype.Service

@Service
class BookSearchUseCase(
    private val bookRepository: IBookRepository
) {
    fun search(form: SearchForm): List<BookSearchResponse> {
        //TODO nullの時検索条件に含めない処理はMyBatis(BookMapperに任せる)
        val result = bookRepository.search(
            form.kanaTitle ?: "",
          form.kanaAuthor ?: "",
            form.isRental)
        return listOf(BookSearchResponse(result[0],null))
    }
}
