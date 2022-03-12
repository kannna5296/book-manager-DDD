package com.book.manager.bookmanager.infra.database.mapper.custom

import java.time.LocalDate
import java.time.LocalDateTime

data class BookWithRentalRecord(
    var id: Long? = null,
    var title: String? = null,
    var author: String? = null,
    var release_date: LocalDate? = null,
    var userId: Long? = null,
    var rental_datetime: LocalDateTime? = null,
    var return_deadline: LocalDateTime? = null
)