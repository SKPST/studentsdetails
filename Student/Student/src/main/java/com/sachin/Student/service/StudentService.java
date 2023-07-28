package com.sachin.Student.service;

import com.sachin.Student.entity.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);
    List<Student>  getAllStudent();
    Student getSingle(String studentId);
    Student getByName(String studentName);
    Student updateStudent(Student student);
    void deleteStudent(String studentId);

}
