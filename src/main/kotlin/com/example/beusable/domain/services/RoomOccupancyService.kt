package com.example.beusable.domain.services

import com.example.beusable.domain.model.AccommodationDeclaration
import com.example.beusable.domain.model.Occupancy
import com.example.beusable.domain.model.OccupancyEntry
import com.example.beusable.infrastructure.database.GuestRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class RoomOccupancyService(private val guestRepository: GuestRepository) {

    companion object {
        private val PREMIUM_ROOM_PRICE_MARGIN = BigDecimal(100)
    }

    fun calculateRoomOccupancy(rooms: AccommodationDeclaration): Occupancy {
        val inputGuests = guestRepository.findAllGuests().sortedByDescending { it.offer }.toMutableList()

        val premiumGuestsAll = inputGuests.filter { it.offer >= PREMIUM_ROOM_PRICE_MARGIN }
        val bookedPremiumGuests = premiumGuestsAll.filter { it.offer >= PREMIUM_ROOM_PRICE_MARGIN }.take(rooms.premiumCount).toMutableList()
        inputGuests.removeAll(premiumGuestsAll)

        val bookedEconomyGuests = inputGuests.filter { it.offer < PREMIUM_ROOM_PRICE_MARGIN }.take(rooms.economyCount)
        inputGuests.removeAll(bookedEconomyGuests)

        var premiumRoomsLeft = rooms.premiumCount - bookedPremiumGuests.size
        if(premiumRoomsLeft > 0 && inputGuests.isNotEmpty()) {
            val economyGuestsInPremium = inputGuests.take(premiumRoomsLeft)
            premiumRoomsLeft -= economyGuestsInPremium.size
            bookedPremiumGuests.addAll(economyGuestsInPremium)
        }

        return Occupancy(
            economy = OccupancyEntry(bookedEconomyGuests.size, bookedEconomyGuests.sumOf { it.offer }),
            premium = OccupancyEntry(bookedPremiumGuests.size, bookedPremiumGuests.sumOf { it.offer })
        )
    }
}