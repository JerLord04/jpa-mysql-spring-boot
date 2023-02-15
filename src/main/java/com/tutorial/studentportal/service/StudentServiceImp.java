package com.tutorial.studentportal.service;

import com.tutorial.studentportal.model.Student;
import com.tutorial.studentportal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImp implements StudentServiceInterface{
    @Autowired
    StudentRepository studentRepository;
    @Override
    public String addStudent(Student student){
        studentRepository.save(student);
        return "Success";
    }

    @Override
    public List<Student> getAllStudent(){
        List<Student> students = new ArrayList<Student>();
        studentRepository.findAll().forEach(student1 -> students.add(student1));
        return  students;
//        return studentRepository.findAll(Sort.by(Sort.Direction.DESC , "id"));
    }

    @Override
    public Student getStudentValueById(int id){
        return studentRepository.findById(id).get();
    }

    @Override
    public String deleteStudentValue(int id){
        studentRepository.deleteById(id);
        return "Delete Success";
    }

    @Override
    public Student updateStatdentValue(Student student,int id){
        Student st = studentRepository.findById(id).get();
        if(Objects.nonNull(student.getName()) && !"".equalsIgnoreCase(student.getName())){
            st.setName(student.getName());
        }

        if(Objects.nonNull(student.getLevel()) && !"".equalsIgnoreCase(student.getLevel())){
            st.setLevel(student.getLevel());
        }

        return studentRepository.save(st);
    }
}
