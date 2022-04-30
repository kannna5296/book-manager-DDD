package net.bookmanager.presentation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(
    basePackages = [
        "net.bookmanager.domain",
        "net.bookmanager.usecase"
    ]
)
class Application
fun main(args: Array<String>) {
    runApplication<Application>(*args)
}