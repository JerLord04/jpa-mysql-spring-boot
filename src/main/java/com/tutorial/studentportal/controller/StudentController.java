package com.tutorial.studentportal.controller;

import com.tutorial.studentportal.model.Student;
import com.tutorial.studentportal.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin
public class StudentController {
    @Autowired
    StudentServiceImp studentServiceImp;
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        return studentServiceImp.addStudent(student);
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudent(){
        return studentServiceImp.getAllStudent();
    }

    @GetMapping("/getStudentById/{id}")
    public Student getStudentValueById(@PathVariable("id") int id){
        return studentServiceImp.getStudentValueById(id);
    }

    @DeleteMapping("/getStudentById/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        return studentServiceImp.deleteStudentValue(id);
    }

    @PutMapping("/updateData/{id}")
    public Student updateData(@RequestBody Student student,@PathVariable("id") int id){
        return studentServiceImp.updateStatdentValue(student,id);
    }
}
