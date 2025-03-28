package com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.request;

import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.entity.Courses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String studentName;
    private String email;
    private String phoneNumber;
    private List<Integer> coursesId;
}
