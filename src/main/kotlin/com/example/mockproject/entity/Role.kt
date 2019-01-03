package com.example.mockproject.entity

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "roles")
data class Role(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long=0,

        @NotBlank
        var name: String?,

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "roles_authorities",
                joinColumns = [(JoinColumn(name = "roles_id", referencedColumnName = "id"))],
                inverseJoinColumns = [(JoinColumn(name = "authorities_id", referencedColumnName = "id"))]
        )
        var authorities: Set<Authority> = mutableSetOf()
)