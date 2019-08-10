package com.alex.che.atm.entity;

import com.alex.che.atm.constants.CardOperation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

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
    private Date date;

    @Column(name = "withdrawal")
    private BigInteger withdrawal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", nullable = false, referencedColumnName = "id")
    private Card card;

    @Column(name = "card_operation")
    @Enumerated(EnumType.STRING)
    private CardOperation cardOperation;
}
