package net.bookmanager.domain.rental

interface IRentalRepository {
    fun insert(rental: Rental): Rental
}
