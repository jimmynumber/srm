package com.want.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.want.entity.Student;
import com.want.entity.Teacher;
import com.want.repository.StudentRepository;
import com.want.repository.TeacherRepository;

@RestController
@RequestMapping("jpamanytomany")
public class JpaManyToMany {

    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private TeacherRepository teacherRepository;
    
    // http://localhost:8081/jpamanytomany/test
    @GetMapping("/test")
    public String test()   {

        Set<Teacher> teachers = new HashSet<>();
        Set<Student> students = new HashSet<>();

        Student student1 = new Student();
        student1.setName("zhonghua");
        students.add(student1);
        studentRepository.save(student1);

        Student student2 = new Student();
        student2.setName("zhiran");
        students.add(student2);
        studentRepository.save(student2);

        Teacher teacher1 =new Teacher();
        teacher1.setName("龙老师");
        teacher1.setStudents(students);
        teachers.add(teacher1);
        teacherRepository.save(teacher1);

        return "jpamanytomany";
    }
    
}
