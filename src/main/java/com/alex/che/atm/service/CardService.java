package com.alex.che.atm.service;

import com.alex.che.atm.dto.CardDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CardService extends UserDetailsService {

    CardDTO findCardByNumber(String number);

    CardDTO saveCard(CardDTO cardDTO);
}
