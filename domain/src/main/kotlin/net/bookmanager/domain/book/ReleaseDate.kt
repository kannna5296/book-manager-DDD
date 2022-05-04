package net.bookmanager.domain.book

import net.bookmanager.domain.ValueObject
import java.time.LocalDate

data class ReleaseDate(val value: LocalDate) : ValueObject
