package com.alex.che.atm.service;

import com.alex.che.atm.dto.CardDTO;
import com.alex.che.atm.entity.Card;
import com.alex.che.atm.repository.CardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Objects;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class CardServiceImpl implements CardService {

    private CacheManager cacheManager;
    private CardRepository cardRepository;
    private ModelMapper mapper;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository,
                           ModelMapper mapper,
                           CacheManager cacheManager) {
        this.cardRepository = cardRepository;
        this.mapper = mapper;
        this.cacheManager = cacheManager;
    }

    @Override
    @Cacheable("card")
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public CardDTO findCardByNumber(String number) {
        Card card = cardRepository.findCardByNumber(number);
        return mapper.map(card, CardDTO.class);
    }

    @Override
    public CardDTO saveCard(CardDTO cardDTO) {
        Card card = cardRepository.save(mapper.map(cardDTO, Card.class));
        Objects.requireNonNull(cacheManager.getCache("card")).clear();
        return mapper.map(card, CardDTO.class);
    }

    @Override
    public UserDetails loadUserByUsername(String number) throws UsernameNotFoundException {
        Card card = cardRepository.findCardByNumber(number);
        if (card.getIsBlocked()) {
            throw new UsernameNotFoundException(number);
        }
        return new User(card.getNumber(), card.getPin(), true, true, true, true, new ArrayList<>());
    }
}
