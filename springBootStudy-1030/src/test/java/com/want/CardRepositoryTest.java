package com.want;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.want.entity.Card;
import com.want.repository.CardRepository;

@RunWith(SpringRunner.class)
// SpringJUnit支持，由此引入Spring-Test框架支持！
//启动整个spring的工程
@SpringBootTest
//@DataJpaTest
@Transactional
//@Rollback(false)
public class CardRepositoryTest {
	@Autowired
	private CardRepository cardRepository;

//	@Test
//	public void testQuery() {
//		// 查询操作
//		List<Card> list = cardRepository.findAll();
//		for (Card card : list) {
//			System.out.println(card);
//		}
//	}

	@Test
	public void testRollBank() {
		// 查询操作
		Card card = new Card();

		card.setNum(3);
		cardRepository.save(card);
		// throw new RuntimeException();
	}

}