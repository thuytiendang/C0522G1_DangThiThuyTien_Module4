package com.casestudy.repository.contract;

import com.casestudy.dto.IContractDetailDto;
import com.casestudy.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {

    @Query(value = "select attach_facility.attach_facility_name as nameDto, " +
            "attach_facility.attach_facility_unit as unitDto, sum(ifnull(contract_detail.quantity, 0)) as quantityDto, " +
            "attach_facility.attach_facility_status as statusDto, attach_facility.attach_facility_cost as costDto " +
            "from contract_detail join attach_facility " +
            "on contract_detail.attach_facility_id = attach_facility.attach_facility_id " +
            "where contract_detail.contract_id = :idFind group by attach_facility.attach_facility_id;", nativeQuery = true)
    List<IContractDetailDto> showAll(@Param("idFind") Integer id);
}
