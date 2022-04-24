package net.bookmanager.domain.user

data class Email(val value: String) {

    companion object {
        val EMAIL_REGEX = Regex("^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})");
    }

    init {
        validateEmail(value)
    }

    private fun validateEmail(value: String) {
        require(value.matches(EMAIL_REGEX))
    }
}