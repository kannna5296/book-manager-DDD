package com.book.manager.bookmanager.infra.database.repository

import com.book.manager.bookmanager.domain.model.Rental
import com.book.manager.bookmanager.domain.model.User
import com.book.manager.bookmanager.domain.repository.RentalRepository
import com.book.manager.bookmanager.domain.repository.UserRepository
import com.book.manager.bookmanager.infra.database.mapper.RentalMapper
import com.book.manager.bookmanager.infra.database.mapper.UserMapper
import com.book.manager.bookmanager.infra.database.record.RentalRecord
import com.book.manager.bookmanager.infra.database.record.UserRecord
import org.springframework.stereotype.Repository

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class RentalRepositoryImpl(
    private val rentalMapper: RentalMapper
) : RentalRepository {

    override fun startRental(rental: Rental) {
        rentalMapper.insert(toRecord(rental))
    }

    private fun toRecord(model: Rental): RentalRecord{
        return RentalRecord(model.bookId, model.userId, model.rentalDatetime, model.returnDeadline)
    }

}