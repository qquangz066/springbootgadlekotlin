package com.example.mockproject.entity

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "users")
data class User(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,

        @NotBlank
        var name: String?,

        @NotBlank
        var password: String?,

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "users_roles",
                joinColumns = [(JoinColumn(name = "users_id", referencedColumnName = "id"))],
                inverseJoinColumns = [(JoinColumn(name = "roles_id", referencedColumnName = "id"))]
        )
        var roles: Set<Role> = mutableSetOf()

)