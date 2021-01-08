package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "master")
@Getter
@Setter

public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MASTER_ID")
    private int masterId;
    @Column(name = "MASTER_NAME")
    private String masterName;
    @Column(name = "MASTER_AMOUNT")
    private String masterAmount;
    @OneToMany(mappedBy = "masterPartner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Partner> partners = new ArrayList<>();
    @OneToMany(mappedBy = "masterService", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MasterSer> masterServices = new ArrayList<>();


}
