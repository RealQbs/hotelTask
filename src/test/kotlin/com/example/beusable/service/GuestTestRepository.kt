package com.example.beusable.service

import com.example.beusable.domain.model.Guest
import com.example.beusable.infrastructure.database.GuestRepository
import java.math.BigDecimal

class GuestTestRepository: GuestRepository {

    private val storage = listOf(
        Guest(BigDecimal("23")),
        Guest(BigDecimal("45")),
        Guest(BigDecimal("155")),
        Guest(BigDecimal("374")),
        Guest(BigDecimal("22")),
        Guest(BigDecimal("99.99")),
        Guest(BigDecimal("100")),
        Guest(BigDecimal("101")),
        Guest(BigDecimal("115")),
        Guest(BigDecimal("209"))
    )

    override fun findAllGuests(): List<Guest> = storage

}