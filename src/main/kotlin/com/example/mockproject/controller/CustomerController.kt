package com.example.mockproject.controller

import com.example.mockproject.entity.mongo.Customer
import com.example.mockproject.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/customers")
class CustomerController {

    @Autowired
    lateinit var customerService: CustomerService

//    val customerMapper = Mappers.getMapper(CustomerMapper::class.java)

    @PostMapping
    fun create(@RequestBody customer: Customer) = customerService.create(customer)

    @GetMapping
    fun getAll() = customerService.getAll()

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID) = customerService.delete(id)

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID) = customerService.get(id)

//    @GetMapping("/{id}")
//    fun get(@PathVariable id: UUID) = customerService.get(id).let {
//        CustomerProto.Customer.newBuilder().setId(it.id.toString()).setFirstName(it.firstName).setLastName(it.lastName).build()
//    }
}