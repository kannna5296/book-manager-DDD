package com.book.manager.bookmanager.infra.database.mapper.custom

//MyBatis必要
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface BookWithRentalMapper {

    @Select("SELECT b.id, b.title, b.author, b.release_date, r.user_id, r.rental_datetime, r.return_deadline FROM book b LEFT JOIN rental r ON b.id = r.book_id")
    fun select(): List<BookWithRentalRecord>

    @Select("SELECT b.id, b.title, b.author, b.release_date, r.user_id, r.rental_datetime, r.return_deadline FROM book b LEFT JOIN rental r ON b.id = r.book_id WHERE b.id = #{bookId}")
    fun selectByPrimaryKey(bookId: Long): BookWithRentalRecord

}