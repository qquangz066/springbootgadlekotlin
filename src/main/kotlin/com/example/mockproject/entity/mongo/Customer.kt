package com.example.mockproject.entity.mongo

import java.util.*
import javax.persistence.Id

data class Customer(
        @Id
        var id: UUID = UUID.randomUUID(),
        var firstName: String = "",
        var lastName: String = ""
)
