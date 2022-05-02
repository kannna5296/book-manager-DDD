package net.bookmanager.domain.rental

import net.bookmanager.domain.DomainEntity
import java.time.LocalDate

class Rental(id: Int? = null,
             val userId: UserId,
             val bookId: BookId,
             val rentalDate: RentalDate,
             val returnDeadLine: ReturnDeadLine): DomainEntity(id) {

    //ファクトリメソッド
    companion object{
        fun create(userId: Int, bookId: Int, rentalDate: LocalDate):Rental {
            return Rental(
                userId = UserId(userId),
                bookId = BookId(bookId),
                rentalDate = RentalDate(rentalDate),
                returnDeadLine = ReturnDeadLine(rentalDate.plusDays(7))
            )
        }
    }
}