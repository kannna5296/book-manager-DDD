package net.bookmanager.domain

import net.bookmanager.domain.rental.IRentalRepository

//D014
class AlreadyRentalCheck(
    private val rentalRepository: IRentalRepository
) {
    fun isAvailable(bookId: Int): Boolean {
        val rental = rentalRepository.findByBookId(bookId)?.let { throw IllegalArgumentException("E-D014-001") }
        return true
    }
}
