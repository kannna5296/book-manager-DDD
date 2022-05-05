package net.bookmanager.infra.repository

import net.bookmanager.infra.entity.RentalEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IRentalJpaRepository : JpaRepository<RentalEntity, Int> {
    // TODO JPAデフォルト提供以外に都度必要なメソッド追加
}
