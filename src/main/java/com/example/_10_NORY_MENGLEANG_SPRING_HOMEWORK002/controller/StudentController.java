package com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.controller;

import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.entity.Instructors;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.entity.Students;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.request.StudentRequest;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.response.ApiResponse;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Students>>> getAllStudentsPaginstion(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "3") Integer size) {
        List<Students> students = studentService.getAllStudentsPaginstion(page, size);
        ApiResponse<List<Students>> response = ApiResponse.<List<Students>>builder()
                .message("All students have been successfully fetched.")
                .status(HttpStatus.OK)
                .payload(students)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Students>> getStudentById(@PathVariable("student-id") Integer studentId) {
        Students students = studentService.getStudentById(studentId);
        ApiResponse<Students> response = ApiResponse.<Students>builder()
                .message("The student has been successfully founded.")
                .status(HttpStatus.OK)
                .payload(students)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Students>> createStudent(@RequestBody StudentRequest studentRequest) {
        Students students = studentService.createStudent(studentRequest);
        ApiResponse<Students> response = ApiResponse.<Students>builder()
                .message("The student has been successfully added.")
                .status(HttpStatus.CREATED)
                .payload(students)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Students>> updateStudent(@PathVariable("student-id") Integer studentId,@RequestBody StudentRequest studentRequest) {
        Students students = studentService.updateStudentById(studentId,studentRequest);
        ApiResponse<Students> response = ApiResponse.<Students>builder()
                .message("The instructor has been successfully updated.")
                .status(HttpStatus.OK)
                .payload(students)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("{student-id}")
    public ResponseEntity<ApiResponse<Students>> deleteStudentById(@PathVariable("student-id") Integer studentId) {
        Students students = studentService.deleteStudentById(studentId);
        ApiResponse<Students> response = ApiResponse.<Students>builder()
                .message("The students has been successfully removed.")
                .status(HttpStatus.OK)
                .payload(null)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
