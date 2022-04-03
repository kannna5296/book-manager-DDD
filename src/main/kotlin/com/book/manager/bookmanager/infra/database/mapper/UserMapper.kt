package com.book.manager.bookmanager.infra.database.mapper

//MyBatis必要
import com.book.manager.bookmanager.infra.database.record.UserRecord
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.type.JdbcType

@Mapper
interface UserMapper {

    //主キー検索
    @Select("SELECT id, email, password, name, role_type FROM [user] WHERE id = #{id}")
    fun selectOne(id: Long): UserRecord

    @Results(value =[
        Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
        Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
        Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
        Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
        Result(column = "role_type", property = "roleType", jdbcType = JdbcType.VARCHAR),
    ])
    @Select("SELECT id, email, password, name, role_type FROM [user] WHERE email = #{email}")
    fun selectOneByEmail(email: String): UserRecord

    @Results(value =[
        Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
        Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
        Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
        Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
        Result(column = "role_type", property = "roleType", jdbcType = JdbcType.VARCHAR),
    ])
    @Select("SELECT id, email, password, name, role_type FROM [user] WHERE id = #{id}")
    fun selectByPrimaryKey(id: Long): UserRecord

}