package com.book.manager.bookmanager.infra.database.mapper

//MyBatis必要
import com.book.manager.bookmanager.infra.database.record.BookRecord
import com.book.manager.bookmanager.infra.database.record.RentalRecord
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Select

@Mapper
interface RentalMapper {

    @Insert("INSERT INTO rental (book_id, user_id, rental_datetime, return_deadline) VALUES (#{bookId}, #{userId},#{rentalDatetime},#{returnDeadline})")
    fun insert(model: RentalRecord)

}