package com.book.manager.bookmanager.infra.database.mapper

import com.book.manager.bookmanager.infra.database.record.RentalRecord
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper

@Mapper
interface RentalMapper {

    @Insert("INSERT INTO rental (book_id, user_id, rental_datetime, return_deadline) VALUES (#{bookId}, #{userId},#{rentalDatetime},#{returnDeadline})")
    fun insert(model: RentalRecord)

    @Delete("DELETE FROM rental WHERE book_id = #{bookId}")
    fun deleteByPrimaryKey(bookId: Long)

}