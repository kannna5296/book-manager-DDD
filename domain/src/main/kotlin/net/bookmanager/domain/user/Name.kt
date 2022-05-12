package net.bookmanager.domain.user

import net.bookmanager.domain.ValueObject

//D011
data class Name(val value: String) : ValueObject {

    init {
        checkName(value)
    }

    private fun checkName(value: String) {
        require(value.isNotEmpty()) { "E-D011-001" }
        require(value.length <= 20) { "E-D011-002" }
    }
}
