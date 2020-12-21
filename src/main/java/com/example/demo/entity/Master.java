package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="master")
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MASTER_ID")
    private int masterId;
    @Column(name = "MASTER_NAME")
    private String masterName;
    @OneToMany(mappedBy = "masterPartner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Partner> partners = new ArrayList<>();
    @OneToMany(mappedBy = "masterService", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MasterService> masterServices = new ArrayList<>();

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public List<Partner> getPartners() {
        return partners;
    }

    public void setPartners(List<Partner> partners) {
        this.partners = partners;
    }

    public List<MasterService> getMasterServices() {
        return masterServices;
    }

    public void setMasterServices(List<MasterService> masterServices) {
        this.masterServices = masterServices;
    }
}
