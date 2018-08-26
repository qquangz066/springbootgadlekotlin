package com.example.mockproject.mapper

import com.example.mockproject.entity.mongo.PhoneType
import com.example.mockproject.entity.mongo.Student
import com.example.mockproject.proto.CourseProto
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class StudentMapper {
    abstract fun student(student: CourseProto.Student): Student


    fun type(type: CourseProto.PhoneType): PhoneType{
        return PhoneType.valueOf(type.name)
    }
}