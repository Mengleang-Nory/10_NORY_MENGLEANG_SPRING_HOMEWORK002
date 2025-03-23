package com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.controller;

import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.entity.Instructors;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.request.InstructorRequest;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.response.ApiResponse;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/instructor")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructors>>> getAllInstructorsPaginstion(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "3") Integer size) {
        List<Instructors> instructors = instructorService.getAllInstructorsPaginstion(page, size);
        ApiResponse<List<Instructors>> response = ApiResponse.<List<Instructors>>builder()
                .message("All instructors have been successfully fetched.")
                .status(HttpStatus.OK)
                .payload(instructors)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Instructors>> getInstructorById(@PathVariable("student-id") Integer studentId) {
        Instructors instructor = instructorService.getInstructorsById(studentId);
        ApiResponse<Instructors> response = ApiResponse.<Instructors>builder()
                .message("The instructor has been successfully founded.")
                .status(HttpStatus.OK)
                .payload(instructor)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Instructors>> createInstructor(@RequestBody InstructorRequest instructorRequest) {
        Instructors instructor = instructorService.createInstructor(instructorRequest);
        ApiResponse<Instructors> response = ApiResponse.<Instructors>builder()
                .message("The instructor has been successfully added.")
                .status(HttpStatus.CREATED)
                .payload(instructor)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Instructors>> updateInstructor(@PathVariable("student-id") Integer studentId, @RequestBody InstructorRequest instructorRequest) {
        Instructors instructor = instructorService.updateInstructorById(studentId, instructorRequest);
        ApiResponse<Instructors> response = ApiResponse.<Instructors>builder()
                .message("The instructor has been successfully updated.")
                .status(HttpStatus.OK)
                .payload(instructor)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Instructors>> deleteInstructor(@PathVariable("student-id") Integer studentId) {
        Instructors instructor = instructorService.deleteInstructorsById(studentId);
        ApiResponse<Instructors> response = ApiResponse.<Instructors>builder()
                .message("The instructor has been successfully removed.")
                .status(HttpStatus.OK)
                .payload(null)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
