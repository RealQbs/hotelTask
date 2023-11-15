package com.example.beusable.service

import com.example.beusable.domain.model.AccommodationDeclaration
import com.example.beusable.domain.model.Occupancy
import com.example.beusable.domain.model.OccupancyEntry
import com.example.beusable.domain.services.RoomOccupancyService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class RoomServiceTest {

    private val roomOccupancyService = RoomOccupancyService(GuestTestRepository())

    @Test
    fun test1() {
        //given
        val accommodationDeclaration = AccommodationDeclaration(
            premiumCount = 3,
            economyCount = 3
        )

        // when
        val result = roomOccupancyService.calculateRoomOccupancy(accommodationDeclaration)

        //then
        assertEquals(
            Occupancy(
                OccupancyEntry(3, BigDecimal("167.99")),
                OccupancyEntry(3, BigDecimal("738"))
            ),  result)
    }

    @Test
    fun test2() {
        //given
        val accommodationDeclaration = AccommodationDeclaration(
            premiumCount = 7,
            economyCount = 5

        )

        // when
        val result = roomOccupancyService.calculateRoomOccupancy(accommodationDeclaration)

        //then
        assertEquals(
            Occupancy(
                OccupancyEntry(4, BigDecimal("189.99")),
                OccupancyEntry(6, BigDecimal("1054"))
            ),  result)
    }

    @Test
    fun test3() {
        //given
        val accommodationDeclaration = AccommodationDeclaration(
            premiumCount = 2,
            economyCount = 7

        )

        // when
        val result = roomOccupancyService.calculateRoomOccupancy(accommodationDeclaration)

        //then
        assertEquals(
            Occupancy(
                OccupancyEntry(4, BigDecimal("189.99")),
                OccupancyEntry(2, BigDecimal("583"))
            ),  result)
    }

    @Test
    fun test4_with_corrected_data() {
        //given
        val accommodationDeclaration = AccommodationDeclaration(
            premiumCount = 7,
            economyCount = 1

        )

        // when
        val result = roomOccupancyService.calculateRoomOccupancy(accommodationDeclaration)

        //then
        assertEquals(
            Occupancy(
                OccupancyEntry(1, BigDecimal("99.99")),
                OccupancyEntry(7, BigDecimal("1099"))
            ),  result)
    }

}



