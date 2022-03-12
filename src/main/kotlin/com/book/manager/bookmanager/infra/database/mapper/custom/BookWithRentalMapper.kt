package com.book.manager.bookmanager.infra.database.mapper.custom

//MyBatis必要
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface BookWithRentalMapper {

//    //主キー検索
//    @Select("SELECT id, title, author, release_date FROM book WHERE id = #{id}")
//    fun select(id: Long): BookRecord

}