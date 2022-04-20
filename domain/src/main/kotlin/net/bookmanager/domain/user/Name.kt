package net.bookmanager.domain.user

data class Name(val value: String) {

    init {
        checkName(value)
    }

    private fun checkName(value: String){
        require(value.isNotEmpty()) {}
        require(value.length <= 20) {}
    }
}