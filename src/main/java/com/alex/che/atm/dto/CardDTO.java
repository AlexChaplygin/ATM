package com.alex.che.atm.dto;

import com.alex.che.atm.entity.Operation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CardDTO {
    private Long id;
    private String number;
    private Boolean isBlocked;
    private String pin;
    private Long wrongAttempts;
    private BigInteger money;
    private List<Operation> operations;
}
