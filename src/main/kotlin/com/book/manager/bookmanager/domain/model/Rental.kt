package com.book.manager.bookmanager.domain.model

import java.time.LocalDateTime

// ドメインオブジェクト
data class Rental(
    val bookId: Long,
    val userId: Long,
    val rentalDatetime: LocalDateTime,
    val returnDeadline: LocalDateTime
)