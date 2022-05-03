package net.bookmanager.domain

import net.bookmanager.domain.book.IBookRepository

//BookVOでチェックさせるのもありか？と思ったけど、repositoryもたせるのがいやなのでやめ
class BookExistenceCheck(
    private val bookRepository: IBookRepository) {

        fun exists(id: Int):Boolean {
            //TODO idに紐づく本データがDBにない場合はここで例外発生してほしい
            // が、現状
            // findByIdのtoDomainModelないで例外になる。
            // どこで例外になるのがええんやろか？

            val book = bookRepository.findById(id) ?: throw IllegalStateException("本が存在しません")
            return true
        }
}