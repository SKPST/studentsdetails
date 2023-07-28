package com.sachin.Student.entity;


import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="student")
public class Student {
    @Id
    private String studentID;
    private String studentName;
    private String studentEmail;
    private long studentPhone;
    private String courseId;
    private int modulesId;
    @Lob
    private byte[] image;
}
