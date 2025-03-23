package com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
    private Integer courseId;
    private String courseName;
    private String courseDescription;
    private Instructors instructors;
}
