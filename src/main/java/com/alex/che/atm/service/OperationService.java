package com.alex.che.atm.service;

import com.alex.che.atm.dao.OperationRepository;
import com.alex.che.atm.entity.Operation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OperationService {

    private OperationRepository operationRepository;

    public void save(Operation operation) {
        operationRepository.save(operation);
    }

    public void delete(Long id) {
        operationRepository.deleteById(id);
    }

    public List<Operation> findAll() {
        return operationRepository.findAll();
    }

    public Operation findById(Long id) {
        return operationRepository.findById(id).get();
    }
}
