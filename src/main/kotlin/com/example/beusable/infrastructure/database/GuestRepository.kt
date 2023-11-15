package com.example.beusable.infrastructure.database

import com.example.beusable.domain.model.Guest

interface GuestRepository {

    fun findAllGuests(): List<Guest>
}