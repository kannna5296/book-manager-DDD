package net.bookmanager.infra.entity

import net.bookmanager.domain.book.Author
import net.bookmanager.domain.book.Book
import net.bookmanager.domain.book.KanaAuthor
import net.bookmanager.domain.book.KanaTitle
import net.bookmanager.domain.book.ReleaseDate
import net.bookmanager.domain.book.Title
import net.bookmanager.domain.rental.Rental
import java.time.LocalDate
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

@Entity
class BookEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var title: String? = null,
    var kanaTitle: String? = null,
    var author: String? = null,
    var kanaAuthor: String? = null,
    var releaseDate: LocalDate? = null,
    @OneToOne(cascade = [CascadeType.ALL], mappedBy = "rental")
    var rental: RentalEntity? = null
) {
    constructor(book: Book) : this(
        title = book.title.value,
        kanaTitle = book.kanaTitle.value,
        author = book.author.value,
        kanaAuthor = book.kanaAuthor.value,
        releaseDate = book.releaseDate.value,
        rental = book.rental?.let { RentalEntity(it) }
    )

    // TODO Domainモデル側にreconsutructorとして持たせるのもあり？（little_handsの例でみた気もする）
    fun toDomainModel(): Book {
        return Book(
            id = id,
            // DBに変な値が入ってた時はNG
            // TODO 共通化させたい
            title = Title(title ?: throw IllegalStateException("")),
            kanaTitle = KanaTitle(kanaTitle ?: throw IllegalStateException("")),
            author = Author(author ?: throw IllegalStateException("")),
            kanaAuthor = KanaAuthor(kanaAuthor ?: throw IllegalStateException("")),
            releaseDate = ReleaseDate(releaseDate ?: throw IllegalStateException("")),
            rental = Rental.create(1, id ?: throw IllegalStateException(""))
        )
    }
}
