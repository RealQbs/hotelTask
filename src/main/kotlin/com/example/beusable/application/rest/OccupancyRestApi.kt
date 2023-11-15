package com.example.beusable.application.rest

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.http.ResponseEntity
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import java.math.BigDecimal

@RequestMapping("/api/occupancy")
interface OccupancyRestApi {

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getOccupancy(
        @RequestBody request: RoomsSpecificationRequest
    ): ResponseEntity<OccupancyResponse>

    data class RoomsSpecificationRequest(
        val premium: Int,
        val economy: Int
    )

    data class OccupancyResponse(
        val premium: OccupancyDetails,
        val economy: OccupancyDetails
    )

    data class OccupancyDetails(
        val usage: Int,
        val count: Money
    )

    data class Money(
        val value: BigDecimal,
        val currency: String
    )
}