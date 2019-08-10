package com.alex.che.atm.service;

import com.alex.che.atm.dto.OperationDTO;
import com.alex.che.atm.entity.Operation;
import com.alex.che.atm.repository.OperationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OperationServiceImpl implements OperationService {

    private OperationRepository operationRepository;
    private ModelMapper modelMapper;

    public OperationServiceImpl(OperationRepository operationRepository,
                                ModelMapper modelMapper) {
        this.operationRepository = operationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OperationDTO saveOperation(OperationDTO operationDTO) {
        Operation operation = operationRepository.save(modelMapper.map(operationDTO, Operation.class));
        return modelMapper.map(operation, OperationDTO.class);
    }
}
