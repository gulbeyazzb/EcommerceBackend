package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.entity.Card;

import java.util.List;

public interface CardService {
    List<Card> getAllCards();
    Card getCardById(long id);
    Card saveCard(Card card);
}
