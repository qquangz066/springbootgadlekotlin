package com.example.mockproject.repository

import com.example.mockproject.entity.Vehicle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface VehicleRepository : JpaRepository<Vehicle, Long>, JpaSpecificationExecutor<Vehicle>