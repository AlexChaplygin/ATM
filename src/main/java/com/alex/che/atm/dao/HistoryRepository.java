package com.alex.che.atm.dao;

import com.alex.che.atm.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
