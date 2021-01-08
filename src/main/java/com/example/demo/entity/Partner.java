package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@JsonIgnoreType
@Entity
@Table(name = "partner")
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PARTNER_ID")
    private int partnerId;
    @Column(name = "PARTNER_NAME")
    private String partnerName;
    @Column(name = "PARTNER_AMOUNT")
    private String partnerAmount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    @JoinColumn(name = "MASTER_ID")
    @JsonBackReference
    private Master masterPartner;

    @OneToMany(mappedBy = "partner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PartnerSer> partnerServices = new ArrayList<>();
    @OneToMany(mappedBy = "partnerClient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Client> clients = new ArrayList<>();

    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPartnerAmount() {
        return partnerAmount;
    }

    public void setPartnerAmount(String partnerAmount) {
        this.partnerAmount = partnerAmount;
    }

    @JsonIgnore
    public Master getMasterPartner() {
        return masterPartner;
    }

    public void setMasterPartner(Master masterPartner) {
        this.masterPartner = masterPartner;
    }

    public List<PartnerSer> getPartnerServices() {
        return partnerServices;
    }

    public void setPartnerServices(List<PartnerSer> partnerServices) {
        this.partnerServices = partnerServices;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
