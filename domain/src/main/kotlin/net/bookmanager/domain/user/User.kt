package net.bookmanager.domain.user

import net.bookmanager.domain.ValueObject

//D014
// TODO SpringSecurityと絡める
class User(var name: Name, var email: Email, var password: Password, val role: Role) : ValueObject
