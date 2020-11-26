package com.want.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.want.entity.Card;

//@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
    Card findById(long id);
    
    //根据查询数据
    public List<Card> findByNum(Integer num);
}
