package net.bookmanager.domain.rental

class Rental(id: Int? = null,
             userId: Int,
             bookId: Int,
             var rentalDate: RentalDate,
             var returnDeadLine: ReturnDeadLine) {

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