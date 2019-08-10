package com.alex.che.atm.dto;

import com.alex.che.atm.constants.CardOperation;
import com.alex.che.atm.entity.Card;
import lombok.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class OperationDTO {
    private Long id;
    private Date date;
    private BigInteger withdrawal;
    private CardDTO card;
    private CardOperation cardOperation;
}
