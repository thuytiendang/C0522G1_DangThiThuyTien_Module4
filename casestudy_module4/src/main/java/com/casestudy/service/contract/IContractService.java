package com.casestudy.service.contract;

import com.casestudy.dto.IContractDto;
import com.casestudy.model.contract.Contract;

import java.util.List;

public interface IContractService {
    List<IContractDto> findAllDto();

//    Page<IContractDto> findAllDto(Pageable pageable);

    void save(Contract contract);

    List<Contract> findAll();
}
