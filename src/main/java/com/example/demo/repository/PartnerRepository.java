package com.example.demo.repository;

import com.example.demo.entity.Master;
import com.example.demo.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Integer> {
    Partner findByPartnerId(int partnerId);

    //find partner by master
    List<Partner> findByMasterPartner(Master master);

    // use JPQL in hibernate for delete Partner
    // when use @Query, method name not valid
    @Transactional
    @Modifying
    @Query(value = "DELETE from Partner  p  WHERE p.partnerId = :partnerId")
    void deletePartnerByPartnerId(@Param("partnerId") int partnerId);
    @Transactional
    @Modifying
    @Query("update Partner p set p.partnerName = ?1, p.partnerAmount= ?2," +
            " p.masterPartner = ?3 where p.partnerId = ?4")
    void updatePartner(String partnerName, String partnerAmount, Master masterId, int partnerId);
}
