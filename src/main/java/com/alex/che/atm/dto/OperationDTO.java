package com.alex.che.atm.dto;

import com.alex.che.atm.entity.Card;
import com.alex.che.atm.entity.CardOperation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class OperationDTO {
    private Long id;
    private LocalTime date;
    private BigInteger withdrawal;
    private Card card;
    private CardOperation codeOperation;
}
