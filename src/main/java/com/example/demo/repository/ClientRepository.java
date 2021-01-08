package com.example.demo.repository;

import com.example.demo.entity.Client;
import com.example.demo.entity.Master;
import com.example.demo.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByClientId(int clientId);
    Client findByClientPhone(String phone);
    @Transactional
    @Modifying
    @Query("update Client p set p.clientName = ?1, p.clientPhone= ?2," +
            " p.clientAmount = ?3, p.partnerClient = ?4 where p.clientId = ?5")
    void updateClient(String clientName, String clientPhone, String clientAmount, Partner partnerClient , int clientId);

}
