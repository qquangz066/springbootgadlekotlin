package com.example.mockproject.entity

import javax.persistence.*

@Entity
data class User(

        @Id
        var id: String?,

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "credentials_roles",
                joinColumns = [(JoinColumn(name = "credentials_id", referencedColumnName = "id"))],
                inverseJoinColumns = [(JoinColumn(name = "roles_id", referencedColumnName = "id"))]
        )
        var roles: Set<Role> = mutableSetOf()

)