package net.bookmanager.usecase.repository

import net.bookmanager.domain.rental.IRentalRepository
import net.bookmanager.domain.rental.Rental

class RentalTestRepository : IRentalRepository {

    private var id = 1
    private var data = mutableMapOf<Int, Rental>()
    override fun insert(rental: Rental): Rental {
        // メモリ上でデータ登録を再現
        rental.id = id
        data[id] = rental
        id ++
        return rental
    }

    override fun findByBookId(bookId: Int): Rental? {
        val searched = data.filter {
            it.value.bookId.value == bookId
        }.values.toList()
        // TODO Rentalテーブル/BookIdはunique制約必要
        if (searched.size > 1) throw IllegalStateException("")

        return if (searched.isEmpty()) {
            null
        } else {
            searched.first()
        }
    }

    fun findById(id: Int): Rental? {
        return data[id]
    }
}
