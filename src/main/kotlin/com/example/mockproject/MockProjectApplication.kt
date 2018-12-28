package com.example.mockproject

import com.example.mockproject.entity.Vehicle
import com.example.mockproject.entity.mongo.Customer
import com.example.mockproject.repository.mongo.CustomerMongoRepository
import com.example.mockproject.repository.mongo.VehicleMongoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
@EnableTransactionManagement
@EnableResourceServer
class MockProjectApplication : CommandLineRunner{
    @Autowired
    lateinit var customerMongoRepository: CustomerMongoRepository
    override fun run(vararg args: String?) {
        customerMongoRepository.save(Customer(firstName = "test",lastName = "test"))
    }

}

fun main(args: Array<String>) {
    runApplication<MockProjectApplication>(*args)
}
