package net.bookmanager.infra.repository

import net.bookmanager.infra.entity.BookEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IBookJpaRepository : JpaRepository<BookEntity, Int?> {
    // TODO JPAデフォルト提供以外に都度必要なメソッド追加
}
