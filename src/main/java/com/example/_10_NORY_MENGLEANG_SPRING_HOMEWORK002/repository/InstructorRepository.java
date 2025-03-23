package com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.repository;

import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.entity.Instructors;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.request.InstructorRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InstructorRepository {

    @Select("""
            select * from instructors limit #{size} offset #{size} * (#{page} - 1);
            """)
    @Results(id = "Instructor", value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name"),
            @Result(property = "instructorEmail", column = "email")
    })
    List<Instructors> findAllInstructorPaginstion(Integer page, Integer size);

    @Select("""
            select * from instructors where instructors.instructor_id = #{studentId};
            """)
    @ResultMap("Instructor")
    Instructors findInstructorById(Integer studentId);

    @Select("""
            insert into instructors(instructor_name, email)
            values (#{instructor.instructorName}, #{instructor.instructorEmail})
            returning *;
            """)
    @ResultMap("Instructor")
    Instructors createInstructor(@Param("instructor") InstructorRequest instructorRequest);

    @Select("""
            update instructors
            set instructor_name = #{instructor.instructorName},
                email           = #{instructor.instructorEmail}
            where instructor_id = #{studentId}
            returning *;
            """)
    @ResultMap("Instructor")
    Instructors updateInstructorById(Integer studentId, InstructorRequest instructorRequest);

    @Select("""
            delete from instructors where instructor_id = #{studentId};
            """)
    Instructors deleteInstructorsById(Integer studentId);
}
