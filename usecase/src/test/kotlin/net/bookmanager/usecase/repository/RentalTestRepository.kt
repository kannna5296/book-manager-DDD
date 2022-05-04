package net.bookmanager.usecase.repository

import net.bookmanager.domain.rental.IRentalRepository
import net.bookmanager.domain.rental.Rental

class RentalTestRepository : IRentalRepository {

    private var id = 1
    private var data = mutableMapOf<Int, Rental>()
    override fun insert(rental: Rental): Rental {
        //メモリ上でデータ登録を再現
        rental.id = id
        data[id] = rental
        id ++
        return rental
    }

    fun findById(id: Int): Rental? {
        return data[id]
    }
}
