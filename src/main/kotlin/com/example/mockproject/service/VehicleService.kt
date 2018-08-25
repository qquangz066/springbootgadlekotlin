package com.example.mockproject.service

import com.example.mockproject.entity.Vehicle

interface VehicleService {
    fun getAll(): List<Vehicle>
    fun create(vehicle: Vehicle): Vehicle
    fun update(id: String, vehicle: Vehicle): Vehicle
    fun get(id: String): Vehicle
    fun delete(id: String): Boolean
    fun search(vin: String?, make: String?, model: String?, color: String?, bodyType: String?): List<Vehicle>
}