package com.book.manager.bookmanager.domain.model

//JOINをしようとするとコレを作らんといけない？？
data class BookWithRental(
    val book: Book,
    val rental: Rental?
) {
    val isRental: Boolean
        get() = rental != null
}