package com.casestudy.service.contract.impl;

import com.casestudy.dto.IContractDto;
import com.casestudy.model.contract.Contract;
import com.casestudy.repository.contract.IContractRepository;
import com.casestudy.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public List<IContractDto> findAllDto() {
        return iContractRepository.findAllDto();
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }
}
