package com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.request;


import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.entity.Instructors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    private String courseName;
    private String courseDescription;
    private Integer instructorId;
}
