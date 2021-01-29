package com.example.demo.model;

import com.example.demo.entity.MasterSer;
import com.example.demo.entity.Partner;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
public class MasterDTO {

    private int masterId;
    private String masterName;
    private String masterAmount;
    private List<Partner> partners ;
    private List<MasterSer> masterServices;


}
