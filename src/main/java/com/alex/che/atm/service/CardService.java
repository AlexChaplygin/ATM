package com.alex.che.atm.service;

import com.alex.che.atm.dao.CardRepository;
import com.alex.che.atm.entity.Card;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CardService {

    private CardRepository cardRepository;

    public void save(Card card) {
        cardRepository.save(card);
    }

    public void delete(Long id) {
        cardRepository.deleteById(id);
    }

    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    public Card findById(Long id) {
        return cardRepository.findById(id).get();
    }

    public Card findCardByCardNumber(String number) {
        return cardRepository.findCardByCardNumber(number);
    }
}
