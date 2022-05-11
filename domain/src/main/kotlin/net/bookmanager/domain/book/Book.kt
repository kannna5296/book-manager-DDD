package net.bookmanager.domain.book

import net.bookmanager.domain.DomainEntity
import net.bookmanager.domain.rental.Rental

class Book(
    id: Int? = null,
    var title: Title,
    var kanaTitle: KanaTitle,
    var author: Author,
    var kanaAuthor: KanaAuthor,
    var releaseDate: ReleaseDate,
    var rental: Rental? = null
) : DomainEntity(id)
