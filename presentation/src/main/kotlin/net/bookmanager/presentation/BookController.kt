package net.bookmanager.presentation

import net.bookmanager.infra.jpa.entity.CourseEntity
import net.bookmanager.infra.jpa.entity.StudentEntity
import net.bookmanager.infra.jpa.repository.CourseJpaRepository
import net.bookmanager.infra.jpa.repository.StudentJpaRepository
import net.bookmanager.usecase.detail.BookDetailResponse
import net.bookmanager.usecase.detail.BookDetailUseCase
import net.bookmanager.usecase.register.BookRegisterParam
import net.bookmanager.usecase.register.BookRegisterResponse
import net.bookmanager.usecase.register.BookRegisterUseCase
import net.bookmanager.usecase.rental.BookRentalResponse
import net.bookmanager.usecase.rental.BookRentalUseCase
import net.bookmanager.usecase.search.BookSearchResponse
import net.bookmanager.usecase.search.BookSearchUseCase
import net.bookmanager.usecase.search.SearchForm
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(
    private val bookRegisterUseCase: BookRegisterUseCase,
    private val bookRentalUseCase: BookRentalUseCase,
    private val bookDetailUseCase: BookDetailUseCase,
    private val bookSearchUseCase: BookSearchUseCase,
    private val studentJpaRepository: StudentJpaRepository,
    private val courceJpaRepository: CourseJpaRepository
) {

    @PostMapping("/student")
    fun student(): ResponseEntity<StudentEntity> {
        // リクエストボディ生成の代わり
        // ホントはドメインエンティティ
        val courseEntity1 = CourseEntity(name = "math")
        val courseEntity2 = CourseEntity(name = "science")
        val student = StudentEntity(name = "test_student", likedCourse = listOf(courseEntity1, courseEntity2))
        // ここまでリクエストボディ生成（usecase層でやること）

        // ここからインフラ層のお話
        // 作られたDomainEntityを基に、infra用エンティティを生成（今は両方infra用entityにしてるけど）
        val newStudent = StudentEntity(
            name = student.name,
            likedCourse = student.likedCourse.map {
                // ホントは!!やめる
                courceJpaRepository.findByName(it.name!!)
            }
        )
        val result = studentJpaRepository.save(newStudent)
        return ResponseEntity.ok(result)
    }

    @GetMapping("/student")
    fun getStudent(): ResponseEntity<StudentEntity> {
        val result = studentJpaRepository.getById(1)
        return ResponseEntity.ok(result)
    }

    @GetMapping("/book/search")
    fun searchA(@ModelAttribute form: SearchForm, pageable: Pageable): ResponseEntity<Page<BookSearchResponse>> {
        val result = bookSearchUseCase.search(form, pageable)
        val page: Page<BookSearchResponse> = PageImpl<BookSearchResponse>(result, pageable, result.size.toLong())
        return ResponseEntity.ok(page)
    }

    @GetMapping("/book/{bookId}")
    fun detail(@PathVariable(required = true) bookId: Int): ResponseEntity<BookDetailResponse> {
        return ResponseEntity.ok(bookDetailUseCase.get(bookId))
    }

    @PostMapping("/book")
    fun register(@RequestBody param: BookRegisterParam): ResponseEntity<BookRegisterResponse> {
        return ResponseEntity.ok(bookRegisterUseCase.register(param))
    }

    @PutMapping("/book/{bookId}/rental")
    fun rental(@PathVariable(required = true) bookId: Int): ResponseEntity<BookRentalResponse> {
        return ResponseEntity.ok(bookRentalUseCase.rental(bookId))
    }
}
