package com.example.mockproject.repository.mongo

import com.example.mockproject.entity.mongo.Customer
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*


interface CustomerMongoRepository : MongoRepository<Customer, UUID> {

    fun findByFirstName(firstName: String): Customer
    fun findByLastName(lastName: String): List<Customer>

}