package com.book.manager.bookmanager.domain.repository

import com.book.manager.bookmanager.domain.model.User

interface UserRepository {
    fun find(email: String): User?
    fun find(id: Long): User?
}