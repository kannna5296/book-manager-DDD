package com.book.manager.bookmanager.infra.database.repository

import com.book.manager.bookmanager.domain.model.Book
import com.book.manager.bookmanager.domain.model.BookWithRental
import com.book.manager.bookmanager.domain.model.Rental
import com.book.manager.bookmanager.domain.repository.BookRepository
import com.book.manager.bookmanager.infra.database.mapper.BookMapper
import com.book.manager.bookmanager.infra.database.mapper.custom.BookWithRentalMapper
import com.book.manager.bookmanager.infra.database.mapper.custom.BookWithRentalRecord
import com.book.manager.bookmanager.infra.database.record.BookRecord
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class BookRepositoryImpl(
    private val bookWithRentalMapper: BookWithRentalMapper,
    private val bookMapper: BookMapper
) : BookRepository {

    override fun findAllWithRental(): List<BookWithRental> {
        return bookWithRentalMapper.select().map { toModel(it) }
    }

    override fun findWithRental(id: Long): BookWithRental? {
        return bookWithRentalMapper.selectByPrimaryKey(id)?.let { toModel(it) }
    }

    override fun register(book: Book) {
        bookMapper.insert(toRecord(book))
    }

    override fun update(id: Long, title: String?, author: String?, releaseDate: LocalDate?) {
        bookMapper.updateByPrimaryKeySelective(BookRecord(id, title, author, releaseDate))
    }

    override fun delete(id: Long) {
        bookMapper.deleteByPrimaryKey(id)
    }

    private fun toModel(record: BookWithRentalRecord): BookWithRental {
        val book = Book(
            record.id!!,
            record.title!!,
            record.author!!,
            record.release_date!!
        )
        val rental = record.userId?.let {
            Rental(
                record.id!!,
                record.userId!!,
                record.rental_datetime!!,
                record.return_deadline!!
            )
        }
        return BookWithRental(book, rental)
    }

    private fun toRecord(model: Book): BookRecord {
        return BookRecord(model.id, model.title, model.author, model.releaseDate)
    }
}