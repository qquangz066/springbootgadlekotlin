package com.example.mockproject.entity

import javax.persistence.*

@Entity
data class Role(
        var id: Int,

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "roles_authorities",
                joinColumns = [(JoinColumn(name = "roles_id", referencedColumnName = "id"))],
                inverseJoinColumns = [(JoinColumn(name = "authorities_id", referencedColumnName = "id"))]
        )
        var authorities: List<Authority> = mutableListOf()
)