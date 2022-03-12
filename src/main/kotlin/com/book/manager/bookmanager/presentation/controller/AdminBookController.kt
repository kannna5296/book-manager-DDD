package com.book.manager.bookmanager.presentation.controller

import com.book.manager.bookmanager.application.service.AdminBookService
import com.book.manager.bookmanager.application.service.BookService
import com.book.manager.bookmanager.domain.model.Book
import com.book.manager.bookmanager.presentation.form.*
import org.springframework.web.bind.annotation.*

//管理車権限で操作できるため、BookControllerとは別にする
@RestController
@RequestMapping("admin/book")
@CrossOrigin
class AdminBookController(
    private val adminBookService: AdminBookService
) {
    @PostMapping("/register")
    fun register(@RequestBody request: RegisterBookRequest) {
        adminBookService.register(
            Book(
                request.id,
                request.title,
                request.author,
                request.releaseDate
            )
        )
    }

    @PutMapping("/update")
    fun update(@RequestBody request: UpdateBookRequest) {
        adminBookService.update(request.id, request.title, request.author, request.releaseDate)
    }

    @DeleteMapping("/delete/{book_id}")
    fun delete(@PathVariable("book_id") bookId: Long) {
        adminBookService.delete(bookId)
    }
}