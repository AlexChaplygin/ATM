package com.alex.che.atm.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CardLoginRequest {
    private String number;
    private String pin;
}
