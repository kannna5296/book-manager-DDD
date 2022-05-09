package net.bookmanager.domain.book

import org.springframework.data.domain.Pageable

interface IBookRepository {
    fun insert(book: Book): Book
    fun findById(id: Int): Book?
    // 前方一致の仕様があるため、VOでなくString
    // UseCaseの知識っぽいよなぁ
    fun search(kanaTitle: String?, kanaAuthor: String?, isRental: Boolean?, pageable: Pageable): List<Book>
}
