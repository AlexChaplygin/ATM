package com.alex.che.atm.dto;

import com.alex.che.atm.entity.Operation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CardDTO {
    private Long id;
    private String number;
    private Boolean isBlocked;
    @JsonIgnore
    private String pin;
    @JsonIgnore
    private Long wrongAttempts;
    private BigInteger money;
    private List<Operation> operations;
}
