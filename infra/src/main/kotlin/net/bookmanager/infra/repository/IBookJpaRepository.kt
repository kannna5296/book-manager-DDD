package net.bookmanager.infra.repository

import net.bookmanager.domain.book.IBookRepository
import net.bookmanager.infra.entity.BookEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IBookJpaRepository : JpaRepository<BookEntity, Int?> , IBookRepository{
    // TODO JPAデフォルト提供以外に都度必要なメソッド追加
}
