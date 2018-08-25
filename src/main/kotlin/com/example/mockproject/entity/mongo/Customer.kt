package com.example.mockproject.entity.mongo

import org.bson.types.ObjectId
import java.util.*
import javax.persistence.Id

data class Customer(
        @Id
        var id: UUID= UUID.randomUUID(),
        var firstName: String,
        var lastName: String
)