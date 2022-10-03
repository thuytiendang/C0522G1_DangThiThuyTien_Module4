package com.casestudy.repository.facility;

import com.casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {

    @Query(value = "select * from facility where facility_name like %:facilityName% and is_delete = 0 ", nativeQuery = true,
            countQuery = "select count(*) from (select * from facility where facility_name like %:facilityName% and is_delete = 0 ) temp_table")
    Page<Facility> search(Pageable pageable, @Param("facilityName") String facilityName);

    @Modifying
    @Transactional
    @Query(value = "update facility set is_delete = 1 where facility_id = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") Integer id);
}
