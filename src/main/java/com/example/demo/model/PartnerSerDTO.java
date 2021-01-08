package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

public class PartnerSerDTO {
    private int partnerSerId;
    private String serviceName;
    private String serviceDesc;
    private String serviceStatus;
    private int partnerId;

}
