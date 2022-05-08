package net.bookmanager.usecase.repository

import net.bookmanager.domain.book.Book
import net.bookmanager.domain.book.IBookRepository

class BookTestRepository : IBookRepository {

    private var id = 1
    private var data = mutableMapOf<Int, Book>()

    override fun insert(book: Book): Book {
        // メモリ上でデータ登録を再現
        book.id = id
        data[id] = book
        id ++
        return book
    }

    override fun findById(id: Int): Book? {
        return data[id]
    }

    // TODO テストしづらい！！！
    override fun search(kanaTitle: String?, kanaAuthor: String?, isRental: Boolean?): List<Book> {
        return data.values.toList()
    }
}
