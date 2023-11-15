package com.example.beusable.application.rest

import com.example.beusable.domain.model.AccommodationDeclaration
import com.example.beusable.domain.model.Occupancy
import org.springframework.stereotype.Service

private const val CURRENCY_EUR = "EUR"

@Service
class RoomSpecificationMapper {
    fun fromRequest(roomSpecRequest: OccupancyRestApi.RoomsSpecificationRequest): AccommodationDeclaration {
        return AccommodationDeclaration(
            roomSpecRequest.premium,
            roomSpecRequest.economy
        )
    }
    fun toResponse(occupancy: Occupancy): OccupancyRestApi.OccupancyResponse {
        return OccupancyRestApi.OccupancyResponse(
            OccupancyRestApi.OccupancyDetails(
                occupancy.premium.roomCount,
                OccupancyRestApi.Money(
                    occupancy.premium.sum,
                    CURRENCY_EUR
                )
            ),
            OccupancyRestApi.OccupancyDetails(
                occupancy.economy.roomCount,
                OccupancyRestApi.Money(
                    occupancy.economy.sum,
                    CURRENCY_EUR
                )
            )
        )
    }
}