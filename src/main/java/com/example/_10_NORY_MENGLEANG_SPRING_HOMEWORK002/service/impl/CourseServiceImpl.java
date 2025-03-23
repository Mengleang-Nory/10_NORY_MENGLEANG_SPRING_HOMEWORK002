package com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.service.impl;

import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.entity.Courses;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.request.CourseRequest;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.repository.CourseRepository;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Courses> getAllCoursesPaginstion(Integer page, Integer size) {
        return courseRepository.findAllCoursePaginstion(page,size);
    }

    @Override
    public Courses getCourseById(Integer courseId) {
        return courseRepository.findCourseById(courseId);
    }

    @Override
    public Courses createCourse(CourseRequest courseRequest) {
        return courseRepository.insertCourse(courseRequest);
    }

    @Override
    public Courses updateCourseById(Integer courseId, CourseRequest courseRequest) {
        return courseRepository.updateCourseById(courseId,courseRequest);
    }

    @Override
    public Courses deleteCourseById(Integer courseId) {
        return courseRepository.deleteCourseById(courseId);
    }
}
