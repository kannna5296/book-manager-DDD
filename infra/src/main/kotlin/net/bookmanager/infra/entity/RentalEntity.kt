package net.bookmanager.infra.entity

import net.bookmanager.domain.rental.Rental
import net.bookmanager.domain.rental.UserId
import net.bookmanager.domain.rental.BookId
import net.bookmanager.domain.rental.RentalDate
import net.bookmanager.domain.rental.ReturnDeadline
import java.time.LocalDate

class RentalEntity(
    var id: Int? = null,
    val userId: Int?,
    val bookId: Int?,
    val rentalDate: LocalDate?,
    val returnDeadline: LocalDate?
) {
    constructor(rental: Rental) : this(
        userId = rental.userId.value,
        bookId = rental.bookId.value,
        rentalDate = rental.rentalDate.value,
        returnDeadline = rental.returnDeadline.value
    )

    fun toDomainModel(): Rental {
        return Rental(
            id = id,
            // DBに変な値が入ってた時はNG
            // TODO 共通化させたい
            userId = UserId(userId ?: throw IllegalStateException("")),
            bookId = BookId(bookId ?: throw IllegalStateException("")),
            rentalDate = RentalDate(rentalDate ?: throw IllegalStateException("")),
            returnDeadline = ReturnDeadline(returnDeadline ?: throw IllegalStateException("")),
        )
    }
}
