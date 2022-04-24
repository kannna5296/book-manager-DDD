package net.bookmanager.domain.book

data class KanaTitle(val value:String) {

    companion object {
        val ZENKAKU_REGEX = Regex("^[\\u30A0-\\u30FF]+$")
    }

    init {
        validateKanaTitle(value)
    }

    private fun validateKanaTitle(value: String) {
        require(value.isNotEmpty()) {""}
        require(value.length <= 50) {""}
        require(value.matches(KanaAuthor.ZENKAKU_REGEX))
    }
}