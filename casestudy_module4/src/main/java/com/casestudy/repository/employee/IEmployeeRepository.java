package com.casestudy.repository.employee;

import com.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select * from employee where employee_name like %:employeeName% and employee_address like %:employeeAddress%" +
            " and employee_phone like %:employeePhone% and is_delete = 0 ", nativeQuery = true,
            countQuery = "select count(*) from (select * from employee where employee_name like %:employeeName% " +
                    "and employee_address like %:employeeAddress% and employee_phone like %:employeePhone% and is_delete = 0 ) temp_table")
    Page<Employee> search(Pageable pageable, @Param("employeeName") String employeeName,
                          @Param("employeeAddress") String employeeAddress, @Param("employeePhone") String employeePhone);

    @Modifying
    @Transactional
    @Query(value = "update employee set is_delete = 1 where employee_id = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") Integer id);

}
