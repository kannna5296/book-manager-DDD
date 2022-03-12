package com.book.manager.bookmanager.application.service

//「アプリケーションサービスがインフラに依存する
//interfaceにのみ依存（依存性逆転ナントカ即）
import com.book.manager.bookmanager.domain.model.Book
import com.book.manager.bookmanager.domain.model.BookWithRental
import com.book.manager.bookmanager.domain.repository.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class AdminBookService(
    private val bookRepository: BookRepository
) {
    @Transactional
    fun register(book: Book) {
        bookRepository.findWithRental(book.id)?.let {
            throw IllegalArgumentException("既に存在する書籍ID: ${book.id}")
        }
        bookRepository.register(book)
    }

    @Transactional
    fun update(bookId: Long, title: String?, author: String?, releaseDate: LocalDate?) {
        bookRepository.findWithRental(bookId) ?: throw IllegalArgumentException("存在しない書籍ID: $bookId")
        bookRepository.update(bookId, title, author, releaseDate)
    }

    @Transactional
    fun delete(bookId: Long) {
        bookRepository.findWithRental(bookId) ?: throw IllegalArgumentException("存在しない書籍ID: $bookId")
        bookRepository.delete(bookId)
    }
}