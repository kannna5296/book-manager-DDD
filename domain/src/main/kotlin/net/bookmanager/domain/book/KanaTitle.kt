package net.bookmanager.domain.book

import net.bookmanager.domain.ValueObject

//D004
data class KanaTitle(val value: String) : ValueObject {

    companion object {
        val ZENKAKU_REGEX = Regex("^[\\u30A0-\\u30FF]+$")
    }

    init {
        validateKanaTitle(value)
    }

    private fun validateKanaTitle(value: String) {
        require(value.isNotEmpty()) { "E-D004-001" }
        require(value.length <= 50) { "E-D004-002" }
        require(value.matches(KanaAuthor.ZENKAKU_REGEX)) { "E-D004-003" }
    }
}
