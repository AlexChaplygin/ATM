package com.alex.che.atm.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class History implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card card;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "operation_id")
    private Operation operation;

    @Column
    private Date date;

    @Column
    private Long moneyAction;

    @Column
    private Long moneyRemain;
}
