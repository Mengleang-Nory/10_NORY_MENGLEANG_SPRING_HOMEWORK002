package com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.controller;

import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.entity.Courses;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.entity.Instructors;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.request.CourseRequest;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.response.ApiResponse;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CouresController {

    private final CourseService courseService;

    public CouresController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Courses>>>
    getAllCoursesPaginstion(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "3") Integer size
    ) {
        List<Courses> courses = courseService.getAllCoursesPaginstion(page, size);
        ApiResponse<List<Courses>> response = ApiResponse.<List<Courses>>builder()
                .message("All courses have been successfully fetched.")
                .status(HttpStatus.OK)
                .payload(courses)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Courses>> getCourseById(@PathVariable("course-id") Integer courseId) {
        Courses courses = courseService.getCourseById(courseId);
        ApiResponse<Courses> response = ApiResponse.<Courses>builder()
                .message("The course has been successfully founded.")
                .status(HttpStatus.OK)
                .payload(courses)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Courses>> createCourse(@RequestBody CourseRequest courseRequest) {
        Courses courses = courseService.createCourse(courseRequest);
        ApiResponse<Courses> response = ApiResponse.<Courses>builder()
                .message("The course has been successfully added.")
                .status(HttpStatus.CREATED)
                .payload(courses)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Courses>> updateCourseById(@PathVariable("course-id") Integer courseId, @RequestBody CourseRequest courseRequest) {
        Courses courses = courseService.updateCourseById(courseId,courseRequest);
        ApiResponse<Courses> response = ApiResponse.<Courses>builder()
                .message("The course has been successfully founded.")
                .status(HttpStatus.OK)
                .payload(courses)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Courses>> deleteCourseById(@PathVariable("course-id") Integer courseId) {
        Courses courses = courseService.deleteCourseById(courseId);
        ApiResponse<Courses> response = ApiResponse.<Courses>builder()
                .message("The course has been successfully removed.")
                .status(HttpStatus.OK)
                .payload(null)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
