package com.book.manager.bookmanager.infra.database.record

//ここでJava使うんや、へぇ〜
import java.time.LocalDate

data class BookRecord(
    var id: Long? = null,
    var title: String? = null,
    var author: String? = null,
    var releaseDate: LocalDate? = null
)