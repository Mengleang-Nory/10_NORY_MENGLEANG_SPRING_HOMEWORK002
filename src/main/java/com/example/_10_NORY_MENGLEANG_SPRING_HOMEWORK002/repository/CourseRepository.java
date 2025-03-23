package com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.repository;

import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.entity.Courses;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.request.CourseRequest;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.service.CourseService;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepository {
    @Select("""
            select * from courses limit #{size} offset #{size} * (#{page} - 1);
            """)
    @Results(id = "Course", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "courseDescription", column = "description"),
            @Result(property = "instructors", column = "instructor_id",
                    one = @One(select = "com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.repository.InstructorRepository.findInstructorById"))
    })
    List<Courses> findAllCoursePaginstion(Integer page, Integer size);

    @Select("""
            select * from courses where course_id = #{courseId};
            """)
    @ResultMap("Course")
    Courses findCourseById(Integer courseId);

    @Select("""
            insert into courses(course_name, description, instructor_id)
            values (#{course.courseName}, #{course.courseDescription}, #{course.instructorId})
            returning *;
            """)
    @ResultMap("Course")
    Courses insertCourse(@Param("course") CourseRequest courseRequest);

    @Select("""
            update courses set course_name = #{course.courseName}, description = #{course.courseDescription}, instructor_id = #{course.instructorId}
            where course_id = #{courseId} returning *;
            """)
    @ResultMap("Course")
    Courses updateCourseById(Integer courseId,@Param("course") CourseRequest courseRequest);


    @Select("""
            delete from courses where course_id = #{courseId};
            """)
    Courses deleteCourseById(Integer courseId);
}
