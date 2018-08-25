package com.example.mockproject.service

import com.example.mockproject.entity.mongo.Customer
import java.util.*

interface CustomerService {
    fun getAll(): List<Customer>
    fun create(customer: Customer): Customer
    fun delete(id: UUID): Boolean
    fun get(id: UUID): Customer
}