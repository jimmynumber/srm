package com.want.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.want.entity.School;
import com.want.entity.Teacher;
import com.want.repository.SchoolRepository;
import com.want.repository.TeacherRepository;

@RestController
@RequestMapping("OneToManyTest")
public class OneToManyTest {

	@Autowired
	private SchoolRepository schoolRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;

	//http://localhost:8081/OneToManyTest/add
    @GetMapping("/add")
    public void add() {
        School school1 = new School();
        school1.setName("清华大学");
        schoolRepository.save(school1);
        
        Teacher teacher = new Teacher();
        teacher.setName("long");
        teacher.setSchool(school1);
        
        teacherRepository.save(teacher);
    }
	
    //http://localhost:8081/OneToManyTest/find
    @GetMapping("/find")
    public void find() {
        School school1 = new School();
        school1 = schoolRepository.findSchoolById(3);
        List<Teacher> teacherList = school1.getTeacherList();
        System.out.println(school1.getName());
        for (Teacher teacher : teacherList) {
            System.out.println(teacher.getName());
        }
    }

    //http://localhost:8081/OneToManyTest/deleteSchoolById
    @GetMapping("/deleteSchoolById")
    public void deleteSchoolById() {
        schoolRepository.deleteById(3);
    }

    //http://localhost:8081/OneToManyTest/deleteTeacherById
    @GetMapping("/deleteTeacherById")
    public void deleteTeacherById() {
        teacherRepository.deleteById(7);
    }
	
	
}
