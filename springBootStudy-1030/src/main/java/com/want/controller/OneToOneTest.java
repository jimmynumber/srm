package com.want.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.want.entity.Card;
import com.want.entity.Student;
import com.want.repository.CardRepository;
import com.want.repository.StudentRepository;

@RestController
@RequestMapping("OneToOneTest")
public class OneToOneTest {
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CardRepository cardRepository;

	// http://localhost:8081/OneToOneTest/test
	@GetMapping("/test")
	public void test() {

		Student student1 = new Student();
		student1.setName("赵大伟");
		student1.setSex("male");
		
		Student student2 = new Student();
		student2.setName("赵大宝");
		student2.setSex("male");

		Card card1 = new Card();
		card1.setNum(422802);
		//student1.setCard(card1);
		studentRepository.save(student1);
		studentRepository.save(student2);
		Card card2 = new Card();
		card2.setNum(422803);
		cardRepository.save(card2);
		/**
		 * Description: 获取添加之后的id
		 */
		Long id = student1.getId();
		/**
		 * Description: 删除刚刚添加的student1
		 */
		studentRepository.deleteById(id);
	}

}
