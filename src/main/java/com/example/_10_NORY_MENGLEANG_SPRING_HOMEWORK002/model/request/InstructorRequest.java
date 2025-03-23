package com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorRequest {
    String instructorName;
    String instructorEmail;
}
