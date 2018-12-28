package com.example.mockproject.entity

import org.springframework.security.core.GrantedAuthority
import javax.persistence.Entity

@Entity
data class Authority(
        var id: Int,
        private var authority: String = ""
) : GrantedAuthority {

    override fun getAuthority() = authority


    fun setAuthority(auth: String) {
        authority = auth
    }
}