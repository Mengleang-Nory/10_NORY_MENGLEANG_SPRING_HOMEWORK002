package com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.service;

import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.entity.Courses;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.request.CourseRequest;

import java.util.List;

public interface CourseService {
    List<Courses> getAllCoursesPaginstion(Integer page, Integer size);

    Courses getCourseById(Integer courseId);

    Courses createCourse(CourseRequest courseRequest);

    Courses updateCourseById(Integer courseId, CourseRequest courseRequest);

    Courses deleteCourseById(Integer courseId);
}
