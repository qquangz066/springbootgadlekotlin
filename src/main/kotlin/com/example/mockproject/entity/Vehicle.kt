package com.example.mockproject.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@EntityListeners(AuditingEntityListener::class)
@JsonIgnoreProperties("createDate", "lastModifiedDate")
data class Vehicle(

        @Id
        var id: String?,

        @NotBlank
        var vin: String?,

        @NotBlank
        var make: String?,

        @NotBlank
        var model: String?,

        @NotBlank
        var color: String?,

        @NotBlank
        var bodyType: String?,

        @NotBlank
        var image: String?,

        @Column(name = "created_date", nullable = false, updatable = false)
        @CreatedDate
        var createDate: LocalDateTime?=null,

        @Column(name = "modified_date")
        @LastModifiedDate
        var lastModifiedDate: LocalDateTime?=null

) : Serializable{

}