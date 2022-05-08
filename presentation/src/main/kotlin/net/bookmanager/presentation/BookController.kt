package net.bookmanager.presentation

import net.bookmanager.usecase.detail.BookDetailResponse
import net.bookmanager.usecase.detail.BookDetailUseCase
import net.bookmanager.usecase.search.BookSearchUseCase
import net.bookmanager.usecase.register.BookRegisterParam
import net.bookmanager.usecase.register.BookRegisterResponse
import net.bookmanager.usecase.register.BookRegisterUseCase
import net.bookmanager.usecase.rental.BookRentalResponse
import net.bookmanager.usecase.rental.BookRentalUseCase
import net.bookmanager.usecase.search.BookSearchResponse
import net.bookmanager.usecase.search.SearchForm
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.GetMapping
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
    private val bookSearchUseCase: BookSearchUseCase
) {

    @GetMapping("/book/search")
    fun search(@ModelAttribute form: SearchForm):ResponseEntity<List<BookSearchResponse>> {
        return ResponseEntity.ok(bookSearchUseCase.search(form))
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
