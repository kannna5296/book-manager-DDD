import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(
    basePackages = [
        "net.bookmanager.domain",
        "net.bookmanager.infra",
        "net.bookmanager.usecase",
        "net.bookmanager.presentation"
    ]
)
class BookApplication
fun main(args: Array<String>) {
    runApplication<BookApplication>(*args)
}