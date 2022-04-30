package net.bookmanager.domain.book

interface IBookRepository {
    fun insert(book: Book): Book
    fun findById(id: Int): Book?
}