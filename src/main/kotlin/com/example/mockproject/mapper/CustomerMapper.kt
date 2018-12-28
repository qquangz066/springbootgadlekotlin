package com.example.mockproject.mapper

import com.example.mockproject.entity.mongo.Customer
import com.example.mockproject.proto.CustomerProto
import org.mapstruct.Mapper
import org.springframework.stereotype.Component
import java.util.*

@Mapper
@Component
abstract class CustomerMapper {

    abstract fun customer(customer: CustomerProto.Customer): Customer

    fun mapStringToUUID(id: String): UUID {
        return UUID.fromString(id)
    }
}