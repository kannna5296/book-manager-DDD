package net.bookmanager.presentation

import net.bookmanager.usecase.register.BookRegisterParam
import net.bookmanager.usecase.register.BookRegisterResponse
import net.bookmanager.usecase.register.BookRegisterUseCase
import net.bookmanager.usecase.rental.BookRentalResponse
import net.bookmanager.usecase.rental.BookRentalUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PathVariable

@RestController
class BookController(
    private val bookRegisterUseCase: BookRegisterUseCase,
    private val bookRentalUseCase: BookRentalUseCase
) {

    @PostMapping("/book")
    fun register(@RequestBody param: BookRegisterParam): ResponseEntity<BookRegisterResponse> {
        return ResponseEntity.ok(bookRegisterUseCase.register(param))
    }

    @PutMapping("/book/{bookId}/rental")
    fun rental(@PathVariable(required = true) bookId: Int): ResponseEntity<BookRentalResponse> {
        return ResponseEntity.ok(bookRentalUseCase.rental(bookId))
    }
}
