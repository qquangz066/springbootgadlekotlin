package com.example.mockproject

import com.example.mockproject.entity.Vehicle
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
class MockprojectApplication : CommandLineRunner{
    @Autowired
    lateinit var vehicleMongoRepository: VehicleMongoRepository
    override fun run(vararg args: String?) {
        vehicleMongoRepository.save(Vehicle("Alice", "Smith","String","String","String","String","String"))
    }

}

fun main(args: Array<String>) {
    runApplication<MockprojectApplication>(*args)
}
