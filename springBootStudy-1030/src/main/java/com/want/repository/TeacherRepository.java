package com.want.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;

import com.want.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	
	Teacher findTeacherById(long id);

	void deleteById(long id);
}
