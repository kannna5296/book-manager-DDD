package net.bookmanager.domain.book

import net.bookmanager.domain.DomainEntity

class Book(
    id: Int? = null,
    var title: Title,
    var kanaTitle: KanaTitle,
    var author: Author,
    var kanaAuthor: KanaAuthor,
    var releaseDate: ReleaseDate,
    var userId: Int? = null
) : DomainEntity(id)
