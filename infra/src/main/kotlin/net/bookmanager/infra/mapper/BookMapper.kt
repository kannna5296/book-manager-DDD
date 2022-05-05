package net.bookmanager.infra.mapper

import net.bookmanager.infra.entity.BookEntity
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
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
            #{kanaTitle},
            #{author},
            #{kanaAuthor},
            #{releaseDate})
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
    // TODO めっちゃ面倒
    @Results(
        value = [
            Result(column = "id", property = "id"),
            Result(column = "title", property = "title"),
            Result(column = "kana_title", property = "kanaTitle"),
            Result(column = "author", property = "author"),
            Result(column = "kana_author", property = "kanaAuthor"),
            Result(column = "release_date", property = "releaseDate"),
        ]
    )
    fun findById(id: Int): BookEntity
}
