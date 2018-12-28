package com.example.mockproject.entity

import org.springframework.security.core.GrantedAuthority
import javax.persistence.*

@Entity
@Table(name = "authorities")
data class Authority(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,

        private var authority: String = ""
) : GrantedAuthority {

    override fun getAuthority() = authority

    fun setAuthority(auth: String) {
        authority = auth
    }
}