package com.book.manager.bookmanager.infra.database.mapper

//MyBatis必要
//Mapper矢野に実際に書いてもうてるけどなんとかならんか？
import com.book.manager.bookmanager.infra.database.record.BookRecord
import org.apache.ibatis.annotations.*

@Mapper
interface BookMapper {

    //主キー検索
    @Select("SELECT id, title, author, release_date FROM book WHERE id = #{id}")
    fun select(id: Long): BookRecord

    @Insert("INSERT INTO book (title, author, release_date) VALUES (#{title},#{author},#{release_date})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    fun insert(model: BookRecord)

    @Update("UPDATE book SET title = #{title}, author = #{author}, release_date = #{release} WHERE id = #{id}")
    fun updateByPrimaryKeySelective(model: BookRecord)

    @Delete("DELETE FROM book WHERE id = #{id}")
    fun deleteByPrimaryKey(id: Long)
}