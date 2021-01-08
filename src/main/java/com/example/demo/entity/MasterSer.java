package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "master_service")
@Data

public class MasterSer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MASTER_SERVICE_ID")
    private int masterServiceId;
    @Column(name = "MASTER_SERVICE_NAME")
    private String serviceName;
    @NotNull
    @Column(name = "MASTER_SERVICE_DESC")
    private String description;
    @Column(name = "MASTER_SERVICE_STATUS")
    private String status;
    @ManyToOne(fetch = FetchType.LAZY,  optional = false)
    @NotNull
    @JoinColumn(name = "master_id")
    private Master masterService;

}
