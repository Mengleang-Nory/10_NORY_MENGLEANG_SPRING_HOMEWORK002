package com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.service;

import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.entity.Instructors;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.request.InstructorRequest;

import java.util.List;

public interface InstructorService {
    List<Instructors> getAllInstructorsPaginstion(Integer page, Integer size);

    Instructors getInstructorsById(Integer studentId);

    Instructors createInstructor(InstructorRequest instructorRequest);

    Instructors updateInstructorById(Integer studentId, InstructorRequest instructorRequest);

    Instructors deleteInstructorsById(Integer studentId);
}
