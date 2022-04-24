package net.bookmanager.domain.book

import net.bookmanager.domain.ValueObject

data class KanaAuthor(val value: String): ValueObject {

    companion object {
        val ZENKAKU_REGEX = Regex("^[\\u30A0-\\u30FF]+$")
    }

    init {
        validateKanaAuthor(value)
    }

    private fun validateKanaAuthor(value: String) {
        require(value.isNotEmpty()) {""}
        require(value.length <= 50) {""}
        require(value.matches(ZENKAKU_REGEX))
    }
}