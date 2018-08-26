package com.example.mockproject.mapper

import com.example.mockproject.entity.mongo.PhoneType
import com.example.mockproject.entity.mongo.Student
import com.example.mockproject.proto.CourseProto
import org.mapstruct.*

@Mapper
interface StudentMapper {
    fun student(student: CourseProto.Student): Student

    @ValueMappings(
        ValueMapping(source = MappingConstants.ANY_UNMAPPED, target = "MOBILE")
    )
    fun type(type: CourseProto.PhoneType): PhoneType
}