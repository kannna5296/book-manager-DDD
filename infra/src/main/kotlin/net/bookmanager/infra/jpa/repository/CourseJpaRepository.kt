package net.bookmanager.infra.jpa.repository

import net.bookmanager.infra.jpa.entity.CourseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseJpaRepository : JpaRepository<CourseEntity, Int> {

    fun findByName(name: String): CourseEntity
}
