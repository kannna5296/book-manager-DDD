package com.book.manager.bookmanager.infra.database.mapper

//MyBatis必要
import com.book.manager.bookmanager.infra.database.record.UserRecord
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface UserMapper {

    //主キー検索
    @Select("SELECT id, email, password, name, role_type FROM user WHERE id = #{id}")
    fun select(id: Long): UserRecord

}