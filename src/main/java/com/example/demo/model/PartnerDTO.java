package com.example.demo.model;

import com.example.demo.entity.Client;
import com.example.demo.entity.PartnerSer;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
public class PartnerDTO {
    private int partnerId;
    private String partnerName;
    private String partnerAmount;
    private int masterId;
    private List<PartnerSer> partnerSers;


}
