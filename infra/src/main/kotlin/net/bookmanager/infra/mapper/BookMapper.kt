package net.bookmanager.infra.mapper

import net.bookmanager.infra.entity.BookEntity
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Select

@Mapper
interface BookMapper {

    @Insert(
        """
        INSERT INTO book
           (
            title,
            kana_title,
            author,
            kana_author,
            release_date)
        VALUES
            (            
            #{title},
            #{kana_title},
            #{author},
            #{kana_author},
            #{release_date})
        """
    )
    @Options(useGeneratedKeys = true, keyProperty = "id")
    fun insert(book: BookEntity)

    @Select(
        """
        SELECT
            id,
            title,
            kana_title,
            author,
            kana_author,
            release_date
        FROM book
        WHERE id = #{id}
        """
    )
    fun findById(id: Int): BookEntity
}