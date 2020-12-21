package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "master_service")
public class MasterService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MASTER_SERVICE_ID")
    private int masterServiceId;
    @Column(name = "MASTER_SERVICE_NAME")
    private String serviceName;
    @NotNull
    @Column(name = "MASTER_SERVICE_DESC")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY,  optional = false)
    @NotNull
    @JoinColumn(name = "master_id")
    private Master masterService;

    public int getMasterServiceId() {
        return masterServiceId;
    }

    public void setMasterServiceId(int masterServiceId) {
        this.masterServiceId = masterServiceId;
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

    public Master getMasterService() {
        return masterService;
    }

    public void setMasterService(Master masterService) {
        this.masterService = masterService;
    }
}
