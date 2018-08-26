package com.example.mockproject.entity.mongo

import javax.persistence.Id

data class Student(
        @Id
        var id: Int?,
        var name: String?,
        var phone: PhoneNumber?,
        var type: PhoneType?
)
{
        constructor():this(null,null,null,null)
}