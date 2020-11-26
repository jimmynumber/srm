package com.want.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.want.entity.School;

public interface SchoolRepository extends JpaRepository<School, Long> {
	
	School findSchoolById(long id);

	void deleteById(long id);
}
