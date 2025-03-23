package com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {
    private Integer studentId;
    private String studentName;
    private String email;
    private String phoneNumber;
    private List<Courses> courses;
}
