package com.example.mockproject.service.impl

import com.example.mockproject.entity.mongo.Customer
import com.example.mockproject.repository.mongo.CustomerMongoRepository
import com.example.mockproject.service.CustomerService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*
import javax.persistence.EntityNotFoundException

@Service
@Transactional
class CustomerServiceImpl(
        private val customerMongoRepository: CustomerMongoRepository
) : CustomerService {
    override fun create(customer: Customer): Customer {
        return customerMongoRepository.save(customer)
    }

    override fun get(id: UUID): Customer {
        return customerMongoRepository.findById(id).orElseThrow { EntityNotFoundException() }
    }

    override fun delete(id: UUID): Boolean {
        return customerMongoRepository.findById(id).map {
            customerMongoRepository.delete(it)
            true
        }.orElseThrow { EntityNotFoundException() }
    }

    override fun getAll(): List<Customer> {
        return customerMongoRepository.findAll()
    }

}