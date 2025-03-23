package com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.service.impl;

import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.entity.Students;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.model.request.StudentRequest;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.repository.StudentRepository;
import com.example._10_NORY_MENGLEANG_SPRING_HOMEWORK002.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Students> getAllStudentsPaginstion(Integer page, Integer size) {
        return studentRepository.getAllStudentsPaginstion(page, size);
    }

    @Override
    public Students getStudentById(Integer studentId) {
        return studentRepository.getStudentById(studentId);
    }

    @Override
    public Students createStudent(StudentRequest studentRequest) {
        Integer studentId = studentRepository.createStudent(studentRequest);

        for (Integer coursesId : studentRequest.getCoursesId()) {
            studentRepository.insertIntoStudentsCourses(studentId, coursesId);
        }

        return studentRepository.getStudentById(studentId);
    }

    @Override
    public Students updateStudentById(Integer studentId, StudentRequest studentRequest) {

        Integer tempStudentId = studentRepository.deleteStudentAndGetStudentId(studentId);
        Integer newStudentId = studentRepository.updateStudentById(tempStudentId, studentRequest);

        for (Integer coursesId : studentRequest.getCoursesId()) {
            studentRepository.insertIntoStudentsCourses(newStudentId, coursesId);
        }

        return studentRepository.getStudentById(newStudentId);
    }

    @Override
    public Students deleteStudentById(Integer studentId) {
        return studentRepository.deleteStudentById(studentId);
    }
}
