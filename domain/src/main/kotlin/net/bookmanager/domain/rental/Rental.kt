package net.bookmanager.domain.rental

import net.bookmanager.domain.DomainEntity
import java.time.LocalDate

//D007
class Rental(
    id: Int? = null,
    val userId: Int,
    val bookId: Int,
    val rentalDate: RentalDate,
    val returnDeadline: ReturnDeadline
) : DomainEntity(id) {

    // ファクトリメソッド
    companion object {
        fun create(userId: Int, bookId: Int): Rental {
            val now = LocalDate.now()
            return Rental(
                userId = userId,
                bookId = bookId,
                rentalDate = RentalDate(now),
                returnDeadline = ReturnDeadline(now.plusDays(7))
            )
        }
    }
}
