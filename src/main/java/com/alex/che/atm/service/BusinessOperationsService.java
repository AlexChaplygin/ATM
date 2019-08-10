package com.alex.che.atm.service;

import com.alex.che.atm.constants.CardOperation;
import com.alex.che.atm.dto.CardDTO;
import com.alex.che.atm.dto.OperationDTO;
import com.alex.che.atm.exception.OutOfBalanceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Date;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class BusinessOperationsService {

    private CardService cardService;
    private OperationService operationService;

    public BusinessOperationsService(CardService cardService,
                                     OperationService operationService) {
        this.cardService = cardService;
        this.operationService = operationService;
    }

    public CardDTO getBalance(String number) {
        CardDTO cardDTO = cardService.findCardByNumber(number);
        operationService.saveOperation(OperationDTO.builder()
                .card(cardDTO)
                .date(new Date())
                .cardOperation(CardOperation.BALANCE)
                .build());
        return cardDTO;
    }

    public void withdrawMoney(String number, String amount) {
        CardDTO cardDTO = cardService.findCardByNumber(number);
        if (cardDTO.getMoney().subtract(new BigInteger(amount)).signum() >= 0) {
            cardDTO.setMoney(cardDTO.getMoney().subtract(new BigInteger(amount)));
            cardService.saveCard(cardDTO);
            operationService.saveOperation(OperationDTO.builder()
                    .card(cardDTO)
                    .date(new Date())
                    .withdrawal(cardDTO.getMoney())
                    .cardOperation(CardOperation.WITHDRAWAL)
                    .build());

        } else {
            throw new OutOfBalanceException("Снимаемая сумма больше чем остаток на карте.");
        }
    }
}
