package com.alex.che.atm.repository;

import com.alex.che.atm.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Card findCardByNumber(String number);
}
