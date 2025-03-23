package com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.service;

import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.entity.Students;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.request.StudentRequest;

import java.util.List;

public interface StudentService {
    List<Students> getAllStudentsPaginstion(Integer page, Integer size);

    Students getStudentById(Integer studentId);

    Students createStudent(StudentRequest studentRequest);

    Students updateStudentById(Integer studentId, StudentRequest studentRequest);

    Students deleteStudentById(Integer studentId);
}
