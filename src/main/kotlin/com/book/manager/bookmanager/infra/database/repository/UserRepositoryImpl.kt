package com.book.manager.bookmanager.infra.database.repository

import com.book.manager.bookmanager.domain.model.Book
import com.book.manager.bookmanager.domain.model.BookWithRental
import com.book.manager.bookmanager.domain.model.Rental
import com.book.manager.bookmanager.domain.model.User
import com.book.manager.bookmanager.domain.repository.BookRepository
import com.book.manager.bookmanager.domain.repository.UserRepository
import com.book.manager.bookmanager.infra.database.mapper.BookMapper
import com.book.manager.bookmanager.infra.database.mapper.UserMapper
import com.book.manager.bookmanager.infra.database.mapper.custom.BookWithRentalMapper
import com.book.manager.bookmanager.infra.database.mapper.custom.BookWithRentalRecord
import com.book.manager.bookmanager.infra.database.record.BookRecord
import com.book.manager.bookmanager.infra.database.record.UserRecord
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class UserRepositoryImpl(
    private val userMapper: UserMapper
) : UserRepository {

    override fun find(email: String): User? {
        val record = userMapper.selectOne(email)
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