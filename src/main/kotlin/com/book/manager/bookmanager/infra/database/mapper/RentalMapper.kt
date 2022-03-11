package com.book.manager.bookmanager.infra.database.mapper

//MyBatis必要
import com.book.manager.bookmanager.infra.database.record.BookRecord
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface RentalMapper {

    //主キー検索
    @Select("SELECT book_id, user_id, rental_datetime, return_deadline FROM book WHERE book_id = #{bookId}")
    fun select(bookId: Long): BookRecord

}