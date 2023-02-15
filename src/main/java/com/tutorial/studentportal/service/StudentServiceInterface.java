package com.tutorial.studentportal.service;

import com.tutorial.studentportal.model.Student;

import java.util.List;

public interface StudentServiceInterface {
    public String addStudent(Student student);
    public List<Student> getAllStudent();
    public Student getStudentValueById(int id);
    public String deleteStudentValue(int id);
    public Student updateStatdentValue(Student student,int id);

}
