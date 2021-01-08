package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name = "partner_service")
public class PartnerSer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PARTNER_SERVICE_ID")
    private int partnerServiceId;
    @Column(name = "PARTNER_SERVICE_NAME")
    private String serviceName;
    @Column(name = "PARTNER_SERVICE_DESC")
    private String description;
    @Column(name = "PARTNER_SERVICE_STATUS")
    private String status;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    @JoinColumn(name = "PARTNER_ID")
    private Partner partner;
    @ManyToMany(mappedBy = "partnerServices")
    @JsonIgnore
    private List<Client> clients = new ArrayList<>();

}
