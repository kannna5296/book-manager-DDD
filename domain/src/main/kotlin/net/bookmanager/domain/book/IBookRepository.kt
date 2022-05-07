package net.bookmanager.domain.book

interface IBookRepository {
    fun insert(book: Book): Book
    fun findById(id: Int): Book?
    //前方一致の仕様があるため、VOでなくString
    fun search(kanaTitle: String, kanaAuthor: String, isRental: Boolean?): List<Book>
}
