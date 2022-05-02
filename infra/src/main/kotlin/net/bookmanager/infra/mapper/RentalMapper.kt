package net.bookmanager.infra.mapper

import net.bookmanager.infra.entity.RentalEntity
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Select

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
        FROM book
        WHERE id = #{id}
        """
    )
    fun findById(id: Int): RentalEntity
}