package net.bookmanager.domain.book

import net.bookmanager.domain.ValueObject
import java.time.LocalDate

//D005
data class ReleaseDate(val value: LocalDate) : ValueObject
