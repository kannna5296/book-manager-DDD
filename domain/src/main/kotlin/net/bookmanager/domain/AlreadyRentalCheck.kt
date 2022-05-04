package net.bookmanager.domain

import net.bookmanager.domain.rental.IRentalRepository

class AlreadyRentalCheck(
    private val rentalRepository: IRentalRepository
) {
        fun isAvailable(bookId: Int):Boolean {
            val rental = rentalRepository.findByBookId(bookId)?.let {throw IllegalStateException("既にレンタルされています")}
            return true
        }
}