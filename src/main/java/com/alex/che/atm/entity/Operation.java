package com.alex.che.atm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalTime date;

    @Column(name = "withdrawal", nullable = false)
    private BigInteger withdrawal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", nullable = false, referencedColumnName = "id")
    private Card card;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_operation_id", referencedColumnName = "id")
    private CardOperation cardOperation;
}
