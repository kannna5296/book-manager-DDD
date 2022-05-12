package net.bookmanager.domain.book

import net.bookmanager.domain.ValueObject

//D006
data class Title(val value: String) : ValueObject {

    init {
        validateTitle(value)
    }

    private fun validateTitle(value: String) {
        require(value.isNotEmpty()) { "E-D006-001" }
        require(value.length <= 30) { "E-D006-002" }
    }
}
