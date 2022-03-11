package com.book.manager.bookmanager.presentation.controller

import com.book.manager.bookmanager.application.service.BookService
import com.book.manager.bookmanager.presentation.form.BookInfo
import com.book.manager.bookmanager.presentation.form.GetBookDetailResponse
import com.book.manager.bookmanager.presentation.form.GetBookListResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
@CrossOrigin
class BookController(
    private val bookService: BookService
) {
    @GetMapping("/list")
    fun getList(): GetBookListResponse {
        val bookList = bookService.getList().map {
            //itって何やねんと思ったらiteratorでした（ループ回すと同義）
            BookInfo(it)
        }
        return GetBookListResponse(bookList)
    }

    @GetMapping("/detail/{book_id}")
    fun getDetail(@PathVariable("book_id") bookId: Long): GetBookDetailResponse {
        val book = bookService.getDetail(bookId)
        return GetBookDetailResponse(book)
    }
}