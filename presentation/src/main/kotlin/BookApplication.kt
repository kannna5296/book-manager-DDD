import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.hibernate5.LocalSessionFactoryBean




@SpringBootApplication
@ComponentScan(
    basePackages = [
        "net.bookmanager.domain",
        "net.bookmanager.infra",
        "net.bookmanager.usecase",
        "net.bookmanager.presentation"
    ]
)
// mapperがスキャンできず、明示的に追加（ホントは要らんっぽい?)
//@MapperScan("net.bookmanager.infra")

class BookApplication
fun main(args: Array<String>) {
    runApplication<BookApplication>(*args)
}