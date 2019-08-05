package com.alex.che.atm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "is_blocked", nullable = false)
    private Boolean isBlocked;

    @Column(name = "pin", nullable = false)
    private String pin;

    @Column(name = "wrong_attempts", nullable = false)
    private Long wrongAttempts;

    @Column(name = "money", nullable = false)
    private BigInteger money;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Operation> operations;
}
