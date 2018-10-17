package com.alex.che.atm.dao;

import com.alex.che.atm.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
