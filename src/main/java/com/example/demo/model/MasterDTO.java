package com.example.demo.model;

import com.example.demo.entity.MasterService;
import com.example.demo.entity.Partner;

import java.util.List;

public class MasterDTO {
    private int masterId;
    private String masterName;
    private List<Partner> partners ;
    private List<MasterService> masterServices;

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
