package com.example.mockproject.service.oauth2

import com.example.mockproject.entity.Role
import com.example.mockproject.repository.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class JdbcUserDetailsService(
        private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findByUserName(username)
                .orElseThrow { EntityNotFoundException("User could not be found") }
                .let {
                    User(it.userName, it.password, getAuthorities(it.roles))
                }
    }

    private fun getAuthorities(roles: Set<Role>): List<SimpleGrantedAuthority> {
        return roles.flatMap { role ->
            role.authorities.map { auth ->
                SimpleGrantedAuthority(auth.authority)
            }
        }
    }

}