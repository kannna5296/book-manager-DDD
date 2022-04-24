package net.bookmanager.domain.book

data class Author(val value:String) {

    init {
        validateAuthor(value)
    }

    private fun validateAuthor(value: String) {
        require(value.isNotEmpty()) {""}
        require(value.length <= 30) {""}
    }
}