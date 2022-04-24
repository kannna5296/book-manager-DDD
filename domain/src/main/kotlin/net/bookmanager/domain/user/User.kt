package net.bookmanager.domain.user

//TODO SpringSecurityと絡める
class User(var name:Name, var email:Email, var password:Password, val role: Role) {
}