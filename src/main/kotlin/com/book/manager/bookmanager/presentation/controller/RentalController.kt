package com.book.manager.bookmanager.presentation.controller

import com.book.manager.bookmanager.application.service.RentalService
import com.book.manager.bookmanager.application.service.security.BookManagerUserDetails
import com.book.manager.bookmanager.presentation.form.RentalStartRequest
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("rental")
@CrossOrigin
class RentalController(private val rentalService: RentalService) {

    @PostMapping("/start")
    fun startRental(@RequestBody request: RentalStartRequest){
        val user = SecurityContextHolder.getContext().authentication.principal as BookManagerUserDetails
        rentalService.startRental(request.bookId,user.id)
    }
}