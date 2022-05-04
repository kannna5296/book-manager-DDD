package net.bookmanager.domain.user

import net.bookmanager.domain.ValueObject

data class Password(val value: String) : ValueObject {

    companion object {
        val REGEX_ALPHA_NUM = Regex("^[A-Za-z0-9]+$") // 半角英数字のみ
    }

    init {
        checkPassword(value)
    }

    private fun checkPassword(value: String) {
        require(value.length >= 8) {}
        require(value.length <= 20) {}
        require(value.matches(REGEX_ALPHA_NUM))
    }
}
