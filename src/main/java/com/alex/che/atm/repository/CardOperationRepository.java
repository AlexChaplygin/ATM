package com.alex.che.atm.repository;

import com.alex.che.atm.entity.CardOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardOperationRepository extends JpaRepository<CardOperation, Long> {
}
