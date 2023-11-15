package com.example.beusable.application.rest

import org.springframework.http.ResponseEntity
import com.example.beusable.domain.services.RoomOccupancyService
import org.springframework.web.bind.annotation.RestController

@RestController
class OccupancyRestController(
    private val roomOccupancyService: RoomOccupancyService,
    private val roomSpecificationMapper: RoomSpecificationMapper
) : OccupancyRestApi {

    override fun getOccupancy(
        request: OccupancyRestApi.RoomsSpecificationRequest
    ): ResponseEntity<OccupancyRestApi.OccupancyResponse> {
        val calculatedRoomsOccupancy = roomOccupancyService.calculateRoomOccupancy(roomSpecificationMapper.fromRequest(request))
        return ResponseEntity.ok(roomSpecificationMapper.toResponse(calculatedRoomsOccupancy))
    }
}