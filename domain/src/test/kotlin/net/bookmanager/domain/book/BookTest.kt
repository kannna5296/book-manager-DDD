package net.bookmanager.domain.book

import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals

class BookTest {

    @Test
    fun `タイトル=銀河鉄道の夜_カナタイトル=ギンガテツドウノヨル_作者=宮沢賢治_作者カナ=ミヤザワケンジ_発売日=1990-01-01の場合作成可能`() {
        val title = Title("銀河鉄道の夜")
        val kanaTitle = KanaTitle("ギンガテツドウノヨル")
        val author = Author("宮沢賢治")
        val kanaAuthor = KanaAuthor("ミヤザワケンジ")
        val releaseDate = ReleaseDate(LocalDate.of(1990, 1, 1))
        val target = Book(
            title = title,
            kanaTitle = kanaTitle,
            author = author,
            kanaAuthor = kanaAuthor,
            releaseDate = releaseDate
        )
        assertEquals(target.title, title)
        assertEquals(target.kanaTitle, kanaTitle)
        assertEquals(target.author, author)
        assertEquals(target.kanaAuthor, kanaAuthor)
        assertEquals(target.releaseDate, releaseDate)
    }
}
