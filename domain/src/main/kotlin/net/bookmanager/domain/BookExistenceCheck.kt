package net.bookmanager.domain

import net.bookmanager.domain.book.IBookRepository

//BookVOでチェックさせるのもありか？と思ったけど、repositoryもたせるのがいやなのでやめ
class BookExistenceCheck(
    private val bookRepository: IBookRepository) {

        fun exists(id: Int):Boolean {
            val book = bookRepository.findById(id) ?: throw IllegalStateException("本が存在しません")
            return true
        }
}