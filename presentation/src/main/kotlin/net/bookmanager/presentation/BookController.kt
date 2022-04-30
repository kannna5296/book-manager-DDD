package net.bookmanager.presentation

import net.bookmanager.usecase.BookRegisterParam
import net.bookmanager.usecase.BookRegisterResponse
import net.bookmanager.usecase.BookRegisterUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/book")
class BookController(
    private val bookRegisterUseCase: BookRegisterUseCase
) {

    @PostMapping("/")
    fun register(@RequestBody param:BookRegisterParam):ResponseEntity<BookRegisterResponse>{
        return ResponseEntity.ok(bookRegisterUseCase.register(param))
    }
}