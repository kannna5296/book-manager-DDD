package net.bookmanager.infra.repository

import net.bookmanager.domain.book.Book
import net.bookmanager.domain.book.IBookRepository
import net.bookmanager.infra.entity.BookEntity
import net.bookmanager.infra.mapper.BookMapper
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class BookRepository(
    private val bookMapper: BookMapper
) : IBookRepository {
    override fun insert(book: Book): Book {
        val entity = BookEntity(book)
        bookMapper.insert(entity)
        // この行からentityにID値が入る(useGeneratedKey)
        // DomainModelにIDがないのでentityから取得
        book.id = entity.id
        return book
    }

    override fun findById(id: Int): Book? {
        return bookMapper.findById(id)?.toDomainModel()
    }

    override fun search(kanaTitle: String?, kanaAuthor: String?, isRental: Boolean?, pageable: Pageable): List<Book> {
        return bookMapper.findByKanaTitleAndKanaAuthorAndIsRental(kanaTitle, kanaAuthor, isRental, pageable).map {
            it.toDomainModel()
        }
    }
}
