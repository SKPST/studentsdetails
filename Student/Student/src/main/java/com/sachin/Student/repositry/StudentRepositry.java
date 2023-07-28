package com.sachin.Student.repositry;

import com.sachin.Student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepositry extends JpaRepository<Student, String> {
	@Query(value = "select * from Student where student_Name = :studentName", nativeQuery = true)
	public Student getAllStudentByName(@Param("studentName") String studentName);
}
