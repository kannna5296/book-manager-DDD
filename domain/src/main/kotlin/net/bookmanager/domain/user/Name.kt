package net.bookmanager.domain.user

data class Name(val value: String) {

    init {
        checkName(value)
    }

    private fun checkName(
        require(value.length >= 8) {}
        require(value.length < 20) {}
    )
}