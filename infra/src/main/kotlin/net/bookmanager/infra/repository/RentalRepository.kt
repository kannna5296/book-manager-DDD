package net.bookmanager.infra.repository

import net.bookmanager.domain.rental.IRentalRepository
import net.bookmanager.domain.rental.Rental
import net.bookmanager.infra.entity.RentalEntity
import net.bookmanager.infra.mapper.RentalMapper
import org.springframework.stereotype.Repository

@Repository
class RentalRepository(
    private val rentalMapper: RentalMapper
): IRentalRepository {

    override fun insert(rental: Rental): Rental {
        val entity = RentalEntity(rental)
        rentalMapper.insert(entity)
        //この行からentityにID値が入る(useGeneratedKey)
        //DomainModelにIDがないのでentityから取得
        rental.id = entity.id
        return rental
    }

    override fun findByBookId(bookId: Int): Rental? {
        return rentalMapper.findByBookId(bookId)?.toDomainModel()
    }
}