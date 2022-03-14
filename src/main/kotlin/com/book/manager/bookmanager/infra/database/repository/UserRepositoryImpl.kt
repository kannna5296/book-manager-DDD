package com.book.manager.bookmanager.infra.database.repository

import com.book.manager.bookmanager.domain.model.User
import com.book.manager.bookmanager.domain.repository.UserRepository
import com.book.manager.bookmanager.infra.database.mapper.UserMapper
import com.book.manager.bookmanager.infra.database.record.UserRecord
import org.springframework.stereotype.Repository

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class UserRepositoryImpl(
    private val userMapper: UserMapper
) : UserRepository {

    override fun find(email: String): User? {
        val record = userMapper.selectOneByEmail(email)
        return record?.let { toModel(it) }
    }

    private fun toModel(record: UserRecord): User {
        return User(
            record.id!!,
            record.email!!,
            record.password!!,
            record.name!!,
            record.roleType!!
        )
    }

}