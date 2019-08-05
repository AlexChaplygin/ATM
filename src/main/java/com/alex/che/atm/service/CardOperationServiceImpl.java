package com.alex.che.atm.service;

import com.alex.che.atm.repository.CardOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class CardOperationServiceImpl implements CardOperationService {

    private CardOperationRepository cardOperationRepository;

    @Autowired
    public CardOperationServiceImpl(CardOperationRepository cardOperationRepository) {
        this.cardOperationRepository = cardOperationRepository;
    }
}
