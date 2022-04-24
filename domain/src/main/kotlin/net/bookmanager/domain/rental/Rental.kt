package net.bookmanager.domain.rental

import net.bookmanager.domain.DomainEntity

class Rental(id: Int? = null,
             val userId: Int,
             val bookId: Int,
             val rentalDate: RentalDate,
             val returnDeadLine: ReturnDeadLine): DomainEntity(id) {

    //ファクトリメソッド
    companion object{
        fun create(userId: Int, bookId: Int, rentalDate: RentalDate):Rental {
            return Rental(
                userId = userId,
                bookId = bookId,
                rentalDate = rentalDate,
                returnDeadLine = ReturnDeadLine(rentalDate.value.plusDays(7))
            )
        }
    }
}