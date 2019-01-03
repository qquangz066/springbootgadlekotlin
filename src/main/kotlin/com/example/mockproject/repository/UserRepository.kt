package com.example.mockproject.repository

import com.example.mockproject.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByUserName(userName: String): Optional<User>
}