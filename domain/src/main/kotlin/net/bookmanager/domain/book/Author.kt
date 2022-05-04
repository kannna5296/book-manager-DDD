package net.bookmanager.domain.book

import net.bookmanager.domain.ValueObject

data class Author(val value: String) : ValueObject {

    init {
        validateAuthor(value)
    }

    private fun validateAuthor(value: String) {
        require(value.isNotEmpty()) { "" }
        require(value.length <= 30) { "" }
    }
}
