package com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.service.impl;

import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.entity.Instructors;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.request.InstructorRequest;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.repository.InstructorRepository;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructors> getAllInstructorsPaginstion(Integer page, Integer size) {
        return instructorRepository.findAllInstructorPaginstion(page,size);
    }

    @Override
    public Instructors getInstructorsById(Integer studentId) {
        return instructorRepository.findInstructorById(studentId);
    }

    @Override
    public Instructors createInstructor(InstructorRequest instructorRequest) {
        return instructorRepository.createInstructor(instructorRequest);
    }

    @Override
    public Instructors updateInstructorById(Integer studentId, InstructorRequest instructorRequest) {
        return instructorRepository.updateInstructorById(studentId,instructorRequest);
    }

    @Override
    public Instructors deleteInstructorsById(Integer studentId) {
        return instructorRepository.deleteInstructorsById(studentId);
    }

}
