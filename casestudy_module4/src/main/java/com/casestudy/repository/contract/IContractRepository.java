package com.casestudy.repository.contract;

import com.casestudy.dto.IContractDto;
import com.casestudy.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface IContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = "select contract.contract_id as contractId, contract.start_day as startDate, " +
            "contract.end_day as endDate, contract.deposit as deposit, facility.facility_name as facilityName, " +
            "employee.employee_name as employeeName, customer.customer_name as customerName, " +
            "(facility.facility_cost + contract.deposit + sum(ifnull(contract_detail.quantity, 0) * ifnull(attach_facility.attach_facility_cost, 0))) " +
            "as totalMoney " +
            "from contract " +
            "left join facility on contract.facility_id = facility.facility_id " +
            "left join employee on contract.employee_id = employee.employee_id " +
            "left join customer on contract.customer_id = customer.customer_id " +
            "left join contract_detail on contract_detail.contract_id = contract.contract_id " +
            "left join attach_facility on attach_facility.attach_facility_id = contract_detail.attach_facility_id " +
            "group by contract.contract_id;",
            nativeQuery = true)
    List<IContractDto> findAllDto();
}
