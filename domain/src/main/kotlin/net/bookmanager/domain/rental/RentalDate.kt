package net.bookmanager.domain.rental

import net.bookmanager.domain.ValueObject
import java.time.LocalDate

//D008
data class RentalDate(val value: LocalDate) : ValueObject
