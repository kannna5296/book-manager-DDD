package net.bookmanager.usecase.query

import org.springframework.stereotype.Service

@Service
class BookDetailUseCase(
    private val bookRepository: IBookQueryRepository
) {
    fun findById(id: Int): BookRecord{
        return bookRepository.findById(id)
    }
}