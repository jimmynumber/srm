package com.want.service;



import java.util.List;

import com.want.entity.Card;


public interface CardService {
    public List<Card> getCardList();
    public Card findCardById(long id);
}
