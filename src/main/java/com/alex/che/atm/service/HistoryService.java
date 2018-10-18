package com.alex.che.atm.service;

import com.alex.che.atm.dao.HistoryRepository;
import com.alex.che.atm.entity.History;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class HistoryService {

    private HistoryRepository historyRepository;

    public void save(History history) {
        historyRepository.save(history);
    }

    public void delete(Long id) {
        historyRepository.deleteById(id);
    }

    public List<History> findAll() {
        return historyRepository.findAll();
    }

    public History findById(Long id) {
        return historyRepository.findById(id).get();
    }
}
