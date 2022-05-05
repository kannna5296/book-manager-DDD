package net.bookmanager.usecase.register

import java.time.LocalDate

class BookRegisterParam(
    val title: String,
    val kanaTitle: String,
    val author: String,
    val kanaAuthor: String,
    val releaseDate: LocalDate
    // TODO 適当コメント
)
