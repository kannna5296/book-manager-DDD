package net.bookmanager.infra.repository

import net.bookmanager.domain.book.Book
import net.bookmanager.domain.book.IBookRepository
import net.bookmanager.infra.entity.BookEntity
import net.bookmanager.infra.mapper.BookMapper
import org.springframework.stereotype.Repository

@Repository
class BookRepository(
    private val bookMapper: BookMapper
): IBookRepository {
    override fun insert(book: Book): Book {
        val entity = BookEntity(book)
        bookMapper.insert(entity)
        return book
    }

    override fun findById(id: Int): Book? {
        val entity = bookMapper.findById(id)
        return entity.toDomainModel()
    }
}