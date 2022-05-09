package net.bookmanager.infra.entity

import net.bookmanager.domain.rental.Rental
import net.bookmanager.domain.rental.RentalDate
import net.bookmanager.domain.rental.ReturnDeadline
import java.time.LocalDate
import javax.persistence.Entity

@Entity
class RentalEntity(
    var id: Int? = null,
    val userId: Int?,
    val bookId: Int?,
    val rentalDate: LocalDate?,
    val returnDeadline: LocalDate?
) {
    constructor(rental: Rental) : this(
        userId = rental.userId,
        bookId = rental.bookId,
        rentalDate = rental.rentalDate.value,
        returnDeadline = rental.returnDeadline.value
    )

    fun toDomainModel(): Rental {
        return Rental(
            id = id,
            // DBに変な値が入ってた時はNG
            // TODO 共通化させたい
            userId = userId ?: throw IllegalStateException(""),
            bookId = bookId ?: throw IllegalStateException(""),
            rentalDate = RentalDate(rentalDate ?: throw IllegalStateException("")),
            returnDeadline = ReturnDeadline(returnDeadline ?: throw IllegalStateException("")),
        )
    }
}
