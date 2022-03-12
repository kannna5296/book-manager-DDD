package com.book.manager.bookmanager.infra.database.mapper.custom

//MyBatis必要
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.type.JdbcType

@Mapper
interface BookWithRentalMapper {

    // 冗長なので何とかしたい
    @Results(value =[
        Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
        Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
        Result(column = "author", property = "author", jdbcType = JdbcType.VARCHAR),
        Result(column = "release_date", property = "releaseDate", jdbcType = JdbcType.DATE),
        Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
        Result(column = "rental_datetime", property = "rentalDatetime", jdbcType = JdbcType.TIMESTAMP),
        Result(column = "return_deadline", property = "returnDeadline", jdbcType = JdbcType.TIMESTAMP),
    ])
    @Select("SELECT b.id, b.title, b.author, b.release_date, r.user_id, r.rental_datetime, r.return_deadline FROM book b LEFT JOIN rental r ON b.id = r.book_id")
    fun select(): List<BookWithRentalRecord>

    @Results(value =[
        Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
        Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
        Result(column = "author", property = "author", jdbcType = JdbcType.VARCHAR),
        Result(column = "release_date", property = "releaseDate", jdbcType = JdbcType.DATE),
        Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
        Result(column = "rental_datetime", property = "rentalDatetime", jdbcType = JdbcType.TIMESTAMP),
        Result(column = "return_deadline", property = "returnDeadline", jdbcType = JdbcType.TIMESTAMP),
    ])
    @Select("SELECT b.id, b.title, b.author, b.release_date, r.user_id, r.rental_datetime, r.return_deadline FROM book b LEFT JOIN rental r ON b.id = r.book_id WHERE b.id = #{bookId}")
    fun selectByPrimaryKey(bookId: Long): BookWithRentalRecord

}