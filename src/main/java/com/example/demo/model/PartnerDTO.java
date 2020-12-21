package com.example.demo.model;

import com.example.demo.entity.Client;


public class PartnerDTO {
    private int partnerId;
    private String partnerName;
    private String partnerAmount;
    private int masterId;

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

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }
}
