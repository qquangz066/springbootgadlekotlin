package com.example.mockproject.controller

import com.example.mockproject.entity.Vehicle
import com.example.mockproject.service.VehicleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/vehicles")
class VehicleController() {

    @Autowired
    lateinit var vehicleService: VehicleService

    @GetMapping()
    @PreAuthorize("hasAuthority('user:create') and #oauth2.clientHasRole('user:create')")
    fun getAll(): List<Vehicle> {
        return vehicleService.getAll()
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Long): Vehicle {
        return vehicleService.get(id)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody vehicle: Vehicle): Vehicle {
        return vehicleService.update(id, vehicle)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long): Boolean {
        return vehicleService.delete(id)
    }

    @PostMapping()
    fun create(@RequestBody @Valid vehicle: Vehicle): Vehicle {
        return vehicleService.create(vehicle)
    }

    @GetMapping("/search")
    fun search(@RequestParam(required = false) vin: String?, @RequestParam(required = false) make: String?,
               @RequestParam(required = false) model: String?, @RequestParam(required = false) color: String?, @RequestParam(required = false) bodyType: String?): List<Vehicle> {
        return vehicleService.search(vin, make, model, color, bodyType)
    }
}