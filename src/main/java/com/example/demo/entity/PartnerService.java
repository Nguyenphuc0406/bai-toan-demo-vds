package com.example.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "partner_service")
public class PartnerService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PARTNER_SERVICE_ID")
    private int partnerServiceId;
    @Column(name = "PARTNER_SERVICE_NAME")
    private String serviceName;
    @Column(name = "PARTNER_SERVICE_DESC")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PARTNER_ID")
    private Partner partner;
    @ManyToMany(mappedBy = "partnerServices")
    private List<Client> clients = new ArrayList<>();

    public int getPartnerServiceId() {
        return partnerServiceId;
    }

    public void setPartnerServiceId(int partnerServiceId) {
        this.partnerServiceId = partnerServiceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
