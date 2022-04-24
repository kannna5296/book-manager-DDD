package net.bookmanager.domain.book

import net.bookmanager.domain.ValueObject

data class Title(val value: String): ValueObject {

    init {
        validateTitle(value)
    }

    private fun validateTitle(value: String) {
        require(value.isNotEmpty()) {""}
        require(value.length <= 30) {""}
    }
}