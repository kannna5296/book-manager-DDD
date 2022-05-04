package net.bookmanager.usecase.rental

import net.bookmanager.domain.rental.Rental
import java.time.LocalDate

class BookRentalResponse(
    val id: Int?,
    val userId: Int,
    val bookId: Int,
    val rentalDate: LocalDate,
    val releaseDeadline: LocalDate
) {
    constructor(rental: Rental) : this(
        id = rental.id,
        userId = rental.userId.value,
        bookId = rental.bookId.value,
        rentalDate = rental.rentalDate.value,
        releaseDeadline = rental.returnDeadline.value
    )
}
