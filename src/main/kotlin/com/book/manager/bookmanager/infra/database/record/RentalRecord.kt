package com.book.manager.bookmanager.infra.database.record

import java.time.LocalDateTime

data class RentalRecord(
    var bookId: Long? = null,
    var userId: Long? = null,
    var rentalDatetime: LocalDateTime? = null,
    var returnDeadline: LocalDateTime? = null
)