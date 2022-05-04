package net.bookmanager.usecase.detail

import net.bookmanager.domain.book.IBookRepository

class BookDetailUseCase(
    private val bookRepository: IBookRepository
) {
    fun get(bookId: Int): BookDetailResponse {
        TODO("aaa")
    }
}