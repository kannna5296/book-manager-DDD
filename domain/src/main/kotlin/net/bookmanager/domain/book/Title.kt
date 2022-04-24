package net.bookmanager.domain.book

data class Title(val value: String) {

    init {
        validateTitle(value)
    }

    private fun validateTitle(value: String) {
        require(value.isNotEmpty()) {""}
        require(value.length <= 30) {""}
    }
}