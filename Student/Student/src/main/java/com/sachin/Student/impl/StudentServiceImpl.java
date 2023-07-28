package com.sachin.Student.impl;

import com.sachin.Student.entity.Student;
import com.sachin.Student.exception.ResponseNotFoundException;
import com.sachin.Student.repositry.StudentRepositry;
import com.sachin.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class StudentServiceImpl implements StudentService {
   @Autowired
   private StudentRepositry studentRepositry;

    @Override
    public Student saveStudent(Student student) {
    	String randomId = UUID.randomUUID().toString();
    	student.setStudentID(randomId);
        return studentRepositry.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepositry.findAll();
    }

    @Override
    public Student getSingle(String studentId) {
        return studentRepositry.findById(studentId).orElseThrow(()-> new ResponseNotFoundException("id is not found on Server : "+studentId));
    }

    @Override
    public Student getByName(String studentName) {
        return studentRepositry.getAllStudentByName(studentName);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepositry.save(student);
    }

    @Override
    public void deleteStudent(String studentId) {
    studentRepositry.deleteById(studentId);
    }

}

