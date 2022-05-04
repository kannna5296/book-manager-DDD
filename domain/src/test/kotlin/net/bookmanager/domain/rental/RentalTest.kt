package net.bookmanager.domain.rental

import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals

class RentalTest{

    private val today = LocalDate.now()
    private val after7Days = LocalDate.now().plusDays(7)

    @Test
    fun `ユーザーID=1_書籍ID=1_レンタル日が2040年1月1日の時作成可能`(){
        val userId = 1
        val bookId = 1
        val inputRentalDate = RentalDate(today)
        val target = Rental.create(userId, bookId)
        assertEquals(userId, target.userId.value)
        assertEquals(bookId, target.bookId.value)
        assertEquals(inputRentalDate, target.rentalDate)
        assertEquals(ReturnDeadline(after7Days),target.returnDeadline)
    }
}