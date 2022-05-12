package net.bookmanager.domain.rental

import net.bookmanager.domain.ValueObject
import java.time.LocalDate

//D009
data class ReturnDeadline(val value: LocalDate) : ValueObject
