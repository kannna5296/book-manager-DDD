package net.bookmanager.domain.book

import net.bookmanager.domain.ValueObject

//D003
data class KanaAuthor(val value: String) : ValueObject {

    companion object {
        val ZENKAKU_REGEX = Regex("^[\\u30A0-\\u30FF]+$")
    }

    init {
        validateKanaAuthor(value)
    }

    private fun validateKanaAuthor(value: String) {
        require(value.isNotEmpty()) { "E-D003-001" }
        require(value.length <= 50) { "E-D003-002" }
        require(value.matches(ZENKAKU_REGEX)) { "E-DN003-003" }
    }
}
