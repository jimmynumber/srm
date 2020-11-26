package com.want.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.want.entity.Card;
import com.want.repository.CardRepository;
import com.want.service.CardService;

@Service
@Transactional
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Card> getCardList() {
        return cardRepository.findAll();
    }

    @Override
    public Card findCardById(long id) {
        return cardRepository.findById(id);
    }
    
    //插入一个obj
    public void addCard(Card Card){
        cardRepository.save(Card);
    }
 
    //修改一个obj(jpa是根据id来修改的)
    public void  updateCard(Card Card){
        cardRepository.save(Card);
    }
    //根据id删除一条数据
    public void deleteCardById(Long id){
        cardRepository.deleteById(id);
    }
 
    //查询所有
    public List<Card> findAll(){
        return cardRepository.findAll();
    }
    //根据id查询一条数据(2.0后不能使用findOne了)
    public Card findStudentById(Long id){
        return cardRepository.findById(id).get();
    }
    //根据obj姓名查询多条数据
    public List<Card> findByNum(Integer num){
        return cardRepository.findByNum(num);
    }
}
