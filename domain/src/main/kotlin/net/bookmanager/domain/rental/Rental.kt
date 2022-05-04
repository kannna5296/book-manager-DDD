package net.bookmanager.domain.rental

import net.bookmanager.domain.DomainEntity
import java.time.LocalDate

class Rental(
    id: Int? = null,
    val userId: UserId,
    val bookId: BookId,
    val rentalDate: RentalDate,
    val returnDeadline: ReturnDeadline
) : DomainEntity(id) {

    // ファクトリメソッド
    companion object {
        fun create(userId: Int, bookId: Int): Rental {
            val now = LocalDate.now()
            return Rental(
                userId = UserId(userId),
                bookId = BookId(bookId),
                rentalDate = RentalDate(now),
                returnDeadline = ReturnDeadline(now.plusDays(7))
            )
        }
    }
}
