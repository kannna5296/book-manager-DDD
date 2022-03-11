package com.book.manager.bookmanager.application.service

//「アプリケーションサービスがインフラに依存する
//interfaceにのみ依存（依存性逆転ナントカ即）
import com.book.manager.bookmanager.domain.model.BookWithRental
import com.book.manager.bookmanager.domain.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository
) {
    fun getList(): List<BookWithRental> {
        return bookRepository.findAllWithRental()
    }

    fun getDetail(bookId: Long): BookWithRental {
        return bookRepository.findWithRental(bookId) ?: throw IllegalArgumentException("存在しない書籍ID: $bookId")
    }
}