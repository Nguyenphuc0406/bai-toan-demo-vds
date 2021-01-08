package com.example.demo.repository;

import com.example.demo.entity.Master;
import com.example.demo.entity.MasterSer;
import com.example.demo.entity.Partner;
import com.example.demo.entity.PartnerSer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MasterSerRepository extends JpaRepository<MasterSer, Integer> {
    MasterSer findByMasterServiceId(int masterSerId);
    // use JPQL in hibernate for delete Partner
    // when use @Query, method name not valid
    @Transactional
    @Modifying
    @Query(value = "DELETE from MasterSer ms WHERE ms.masterServiceId = :masterSerId")
    void deleteMasterByMasterSerId(@Param("masterSerId") int masterSerId);
    @Transactional
    @Modifying
    @Query("update MasterSer ps set ps.serviceName = ?1, ps.description= ?2," +
            " ps.masterService = ?3, ps.status =?4 where ps.masterServiceId = ?5")
    void updateMasterSer(String serviceName, String description, Master master, String status, int masterServiceId);
}
