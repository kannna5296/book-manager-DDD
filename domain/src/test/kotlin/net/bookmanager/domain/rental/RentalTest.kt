package net.bookmanager.domain.rental

import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals

class RentalTest{

    @Test
    fun `ユーザーID=1_書籍ID=1_レンタル日が2040年1月1日の時作成可能`(){
        val userId = 1
        val bookId = 1
        val inputRentalDate = RentalDate(LocalDate.of(2040,1,1))
        val target = Rental.create(userId, bookId, inputRentalDate)
        assertEquals(userId, target.userId)
        assertEquals(bookId, target.bookId)
        assertEquals(inputRentalDate, target.rentalDate)
        assertEquals(ReturnDeadLine(inputRentalDate.value.plusDays(7)),target.returnDeadLine)
    }
}