package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARTNER_SERVICE_ID")
    private PartnerService partnerService;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public PartnerService getPartnerService() {
        return partnerService;
    }

    public void setPartnerService(PartnerService partnerService) {
        this.partnerService = partnerService;
    }
}
