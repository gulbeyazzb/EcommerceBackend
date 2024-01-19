package com.workintech.ecommerce.ecommerce.controller;

import com.workintech.ecommerce.ecommerce.entity.Card;
import com.workintech.ecommerce.ecommerce.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    private CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/")
    public Card saveCard(@RequestBody Card card){
        return cardService.saveCard(card);
    }

    @GetMapping("/")
    public List<Card> getAllCards(){
        return cardService.getAllCards();
    }

    @GetMapping("/{id}")
    public Card getCardById(@PathVariable long id){
        return cardService.getCardById(id);
    }
}
