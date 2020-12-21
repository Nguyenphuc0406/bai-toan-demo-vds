package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.sun.istack.NotNull;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLIENT_ID")
    private int clientId;
    @Column(name = "CLIENT_NAME")
    private String clientName;
    @Column(name = "CLIENT_PHONE")
    private String clientPhone;
    @Column(name = "CLIENT_AMOUNT")
    private String clientAmount;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PARTNER_ID")
    private Partner partnerClient;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "transaction", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns =
    @JoinColumn(name = "partner_service_id"))
    private List<PartnerService> partnerServices = new ArrayList<>();

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientAmount() {
        return clientAmount;
    }

    public void setClientAmount(String clientAmount) {
        this.clientAmount = clientAmount;
    }

    public Partner getPartnerClient() {
        return partnerClient;
    }

    public void setPartnerClient(Partner partnerClient) {
        this.partnerClient = partnerClient;
    }

    public List<PartnerService> getPartnerServices() {
        return partnerServices;
    }

    public void setPartnerServices(List<PartnerService> partnerServices) {
        this.partnerServices = partnerServices;
    }
}
