package net.bookmanager.presentation

import net.bookmanager.usecase.BookRegisterParam
import net.bookmanager.usecase.BookRegisterResponse
import net.bookmanager.usecase.BookRegisterUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class BookController(
    private val bookRegisterUseCase: BookRegisterUseCase
) {

    @PostMapping("/book")
    fun register(@RequestBody param:BookRegisterParam):ResponseEntity<BookRegisterResponse>{
        return ResponseEntity.ok(bookRegisterUseCase.register(param))
    }
}