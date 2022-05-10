package net.bookmanager.infra.jpa.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table

//ManyToManyと言いつつ、ある作業において子側となるエンティティ
@Entity
@Table(name = "course")
class CourseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var name: String? = null,
    @ManyToMany(mappedBy = "likedCourse", cascade = [CascadeType.ALL]) //親エンティティのどのフィールドにマッピングされるかと、CASCADETYPE
    @JsonIgnore
    var likes: List<StudentEntity> = listOf()
)
