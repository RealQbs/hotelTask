package com.example.beusable.infrastructure.database

import com.example.beusable.domain.model.Guest
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
class GuestRepositoryImpl: GuestRepository {
    override fun findAllGuests(): List<Guest> = listOf(
        Guest(BigDecimal(23)),
        Guest(BigDecimal(45)),
        Guest(BigDecimal(155)),
        Guest(BigDecimal(374)),
        Guest(BigDecimal(22)),
        Guest(BigDecimal("99.99")),
        Guest(BigDecimal(100)),
        Guest(BigDecimal(101)),
        Guest(BigDecimal(115)),
        Guest(BigDecimal(209))
    )
}