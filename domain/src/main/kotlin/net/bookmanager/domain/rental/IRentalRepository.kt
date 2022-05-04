package net.bookmanager.domain.rental

interface IRentalRepository {
    fun insert(rental: Rental): Rental
    fun findByBookId(bookId: Int): Rental?
}
