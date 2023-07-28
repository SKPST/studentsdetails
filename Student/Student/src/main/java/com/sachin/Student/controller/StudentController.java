package com.sachin.Student.controller;

import com.sachin.Student.entity.Student;
import com.sachin.Student.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/{students}")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student)
    {
        Student student1 = studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student1);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent()
    {
        List<Student> studentList = studentService.getAllStudent();
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/id/{studentId}")
    public ResponseEntity<Student> getSingleStudentById(@PathVariable String studentId)
    {
        Student student = studentService.getSingle(studentId);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student)
    {
        Student student1 = studentService.updateStudent(student);
        return ResponseEntity.ok(student1);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity deleteStudent(@PathVariable String studentId)
    {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(studentId,HttpStatus.OK);
    }
    
    @GetMapping("/name/{studentName}")
    public ResponseEntity<Student> getByName(@PathVariable String studentName){
    	Student student = studentService.getByName(studentName);
    	return ResponseEntity.ok(student);
    }
}
