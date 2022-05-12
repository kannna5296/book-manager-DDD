package net.bookmanager.domain

import net.bookmanager.domain.book.IBookRepository

//D015
// BookVOでチェックさせるのもありか？と思ったけど、repositoryもたせるのがいやなのでやめ
class BookExistenceCheck(
    private val bookRepository: IBookRepository
) {

    fun exists(id: Int): Boolean {
        val book = bookRepository.findById(id) ?: throw IllegalArgumentException("E-D015-001")
        return true
    }
}
