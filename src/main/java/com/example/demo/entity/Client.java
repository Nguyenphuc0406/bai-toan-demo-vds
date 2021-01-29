package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data

@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLIENT_ID")
    private int clientId;
    @Column(name = "CLIENT_NAME")
    private String clientName;
    @Column(name = "CLIENT_PHONE")
    private String clientPhone;
    @Column(name = "CLIENT_AMOUNT")
    private String clientAmount;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    @JoinColumn(name = "PARTNER_ID")
    private Partner partnerClient;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "transaction", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns =
    @JoinColumn(name = "partner_service_id"))
    private List<PartnerSer> partnerServices = new ArrayList<>();

}
