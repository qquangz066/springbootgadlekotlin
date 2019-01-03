package com.example.mockproject.entity

import javax.persistence.*

@Entity
@Table(name = "authorities")
data class Authority(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        var authority: String = ""
)