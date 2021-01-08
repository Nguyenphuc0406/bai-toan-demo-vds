package com.example.demo.repository;

import com.example.demo.entity.Master;
import com.example.demo.entity.Partner;
import com.example.demo.entity.PartnerSer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PartnerSerRepository extends JpaRepository<PartnerSer, Integer> {
    PartnerSer findByPartnerServiceId(int partnerSerId);

    PartnerSer findByServiceName(String serviceName);

    // get
    List<PartnerSer> findByPartner(int partnerId);
    // use JPQL in hibernate for delete Partner
    // when use @Query, method name not valid
    @Transactional
    @Modifying
    @Query(value = "DELETE from PartnerSer  ps  WHERE ps.partnerServiceId = :partnerSerId")
    void deletePartnerByPartnerSerId(@Param("partnerSerId") int partnerSerId);
    @Transactional
    @Modifying
    @Query("update PartnerSer ps set ps.serviceName = ?1, ps.description= ?2," +
            " ps.partner = ?3, ps.status =?4 where ps.partnerServiceId = ?5")
    void updatePartnerSer(String partnerSerName, String description, Partner partner, String status, int partnerSerId);
}
