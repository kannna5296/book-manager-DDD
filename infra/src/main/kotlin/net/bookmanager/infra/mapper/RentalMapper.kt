package net.bookmanager.infra.mapper

import net.bookmanager.infra.entity.RentalEntity
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.Result

@Mapper
interface RentalMapper {

    @Insert(
        """
        INSERT INTO rental
           (
            user_id,
            book_id,
            rental_date,
            return_deadline)
        VALUES
            (            
            #{userId},
            #{bookId},
            #{rentalDate},
            #{returnDeadline})
        """
    )
    @Options(useGeneratedKeys = true, keyProperty = "id")
    fun insert(book: RentalEntity)

    @Select(
        """
        SELECT
            id,
            user_id,
            book_id,
            rental_date,
            return_deadline
        FROM rental
        WHERE id = #{id}
        """
    )
    fun findById(id: Int): RentalEntity

    @Select(
        """
        SELECT
            id,
            user_id,
            book_id,
            rental_date,
            return_deadline
        FROM rental
        WHERE book_id = #{bookId}
        """
    )
    @Results(
        value = [
            Result(column = "id", property = "id"),
            Result(column = "user_id", property = "userId"),
            Result(column = "book_id", property = "bookId"),
            Result(column = "rental_date", property = "rentalDate"),
            Result(column = "return_deadline", property = "returnDeadline")
        ]
    )
    fun findByBookId(bookId: Int): RentalEntity
}