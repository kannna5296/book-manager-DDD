package net.bookmanager.infra.jpa.entity

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.Table

//ManyToManyと言いつつ、ある作業において親側となるエンティティ
@Entity
@Table(name = "student")
class StudentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var name: String? = null,
    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "course_like", //中間テーブルの物理名
        joinColumns = [JoinColumn(name = "course_id", referencedColumnName = "id")],  //中間テーブルの[どのカラムを] [子エンティティのどのカラムと紐づけるか]
        inverseJoinColumns = [JoinColumn(name = "student_id", referencedColumnName = "id")]//中間テーブルの[どのカラムを] [自エンティティのどのカラムと紐づけるか]
    )
    var likedCourse: List<CourseEntity> = listOf()

    //JoinTableを親エンティティ側(のMany子プロパティ)に持たせないと、中間テーブルにIDが登録されないことがあった
)
