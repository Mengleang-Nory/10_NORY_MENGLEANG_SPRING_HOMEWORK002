package com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.repository;

import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.entity.Courses;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.entity.Students;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.request.StudentRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Select("""
            select *
            from students 
            limit #{size} offset #{size} * (#{page} - 1);
            """)
    @Results(id = "Student", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses", column = "student_id",
                    many = @Many(select = "getAllCourseByStudentId"))
    })
    List<Students> getAllStudentsPaginstion(Integer page, Integer size);

    @Select("""
            select *
            from courses as c
                     inner join student_course as sc on c.course_id = sc.course_id
            where student_id = #{studentId};
            """)
    @Results(id = "Course", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "courseDescription", column = "description"),
            @Result(property = "instructors", column = "instructor_id",
                    one = @One(select = "com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.repository.InstructorRepository.findInstructorById"))
    })
    List<Courses> getAllCourseByStudentId(Integer studentId);


    @Select("""
            select * from students where student_id = #{studentId};
            """)
    @ResultMap("Student")
    Students getStudentById(Integer studentId);

    @Select("""
            insert into students (student_name, email, phone_number)
            values (#{student.studentName}, #{student.email}, #{student.phoneNumber})
            returning student_id;
            """)
    Integer createStudent(@Param("student") StudentRequest studentRequest);

    @Insert("""
            insert into student_course (student_id, course_id)\s
            values (#{studentId},#{courseId});
            """)
    void insertIntoStudentsCourses(Integer studentId, Integer courseId);

    @Select("""
            delete from students where student_id = #{studentId};
            """)
    Students deleteStudentById(Integer studentId);

    @Select("""
            delete from students where student_id = #{studentId} 
            returning student_id;
            """)
    Integer deleteStudentAndGetStudentId(Integer studentId);

    @Select("""
            insert into students(student_id,student_name,email, phone_number)
            values (#{newStudentId},#{student.studentName}, #{student.email}, #{student.phoneNumber})
            returning student_id;
            """)
    Integer updateStudentById(Integer newStudentId,@Param("student") StudentRequest studentRequest);
}
