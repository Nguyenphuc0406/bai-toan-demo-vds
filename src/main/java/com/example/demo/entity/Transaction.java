package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    private int transactionId;
    @Column(name = "TRANSACTION_AMOUNT")
    private String transactionAmount;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_ID")
    private Client client;
    @Column(name = "TRANSACTION_PHONE")
    private String transactionPhone;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARTNER_SERVICE_ID")
    private PartnerSer partnerService;
    @Column(name = "PARTNER_ID")
    private int partnerId;
    @Column(name = "TRANSACTION_TIME")
    private String transactionTime;

}
