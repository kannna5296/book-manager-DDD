package net.bookmanager.domain.book

import net.bookmanager.domain.ValueObject

//D001
data class Author(val value: String) : ValueObject {

    init {
        validateAuthor(value)
    }

    private fun validateAuthor(value: String) {
        require(value.isNotEmpty()) { "E-D001-001" }
        require(value.length <= 30) { "E-D001-002" }
    }
}
