package net.bookmanager

import org.springframework.context.MessageSource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.Locale

@RestControllerAdvice
class ApiExceptionHandler(
    private val messageSource: MessageSource
) {

    @ExceptionHandler
    fun handleIllegalArgumentException(ex: IllegalArgumentException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            errorCode = ex.message,
            errorMessage = ex.message?.let { messageSource.getMessage(it, null, Locale.getDefault()) }
        )
        return ResponseEntity.badRequest().body(errorResponse)
    }
}
