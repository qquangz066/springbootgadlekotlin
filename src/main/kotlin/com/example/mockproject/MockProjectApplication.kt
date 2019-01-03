package com.example.mockproject

import com.example.mockproject.entity.Authority
import com.example.mockproject.entity.Role
import com.example.mockproject.entity.User
import com.example.mockproject.entity.mongo.Customer
import com.example.mockproject.repository.AuthorityRepository
import com.example.mockproject.repository.RoleRepository
import com.example.mockproject.repository.UserRepository
import com.example.mockproject.repository.mongo.CustomerMongoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
@EnableTransactionManagement
@EnableResourceServer
class MockProjectApplication : CommandLineRunner {

    @Autowired
    lateinit var customerMongoRepository: CustomerMongoRepository

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var roleRepository: RoleRepository

    @Autowired
    lateinit var authorityRepository: AuthorityRepository

    @Autowired
    lateinit var passwordEncoder: PasswordEncoder

    override fun run(vararg args: String?) {
        if (userRepository.count() < 1) {
            customerMongoRepository.save(Customer(firstName = "test", lastName = "test"))

            val role = roleRepository.save(Role(name = "ADMIN",
                    authorities = setOf(authorityRepository.save(Authority(authority = "user:create")))
            ))
            println(passwordEncoder.encode("admin"))

            userRepository.save(
                    User(userName = "admin", password = passwordEncoder.encode("admin"),
                            name = "admin", roles = setOf(role))
            )
        }

    }

}

fun main(args: Array<String>) {
    runApplication<MockProjectApplication>(*args)
}
