package net.bookmanager.domain.user

import net.bookmanager.domain.ValueObject

data class Name(val value: String) :ValueObject{

    init {
        checkName(value)
    }

    private fun checkName(value: String){
        require(value.isNotEmpty()) {}
        require(value.length <= 20) {}
    }
}