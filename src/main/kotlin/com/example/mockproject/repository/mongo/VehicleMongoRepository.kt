package com.example.mockproject.repository.mongo

import com.example.mockproject.entity.Vehicle
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface VehicleMongoRepository : MongoRepository<Vehicle, String>