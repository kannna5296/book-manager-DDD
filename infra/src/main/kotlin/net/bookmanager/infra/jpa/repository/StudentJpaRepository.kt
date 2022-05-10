package net.bookmanager.infra.jpa.repository

import net.bookmanager.infra.jpa.entity.StudentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentJpaRepository : JpaRepository<StudentEntity,Int>