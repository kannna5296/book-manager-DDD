package net.bookmanager.domain.rental

import net.bookmanager.domain.ValueObject
import java.time.LocalDate

data class ReturnDeadLine(val value: LocalDate) :ValueObject{
}