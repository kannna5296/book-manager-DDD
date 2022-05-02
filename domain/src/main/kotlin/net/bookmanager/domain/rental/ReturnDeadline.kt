package net.bookmanager.domain.rental

import net.bookmanager.domain.ValueObject
import java.time.LocalDate

data class ReturnDeadline(val value: LocalDate) :ValueObject{
}