package com.example.demo.entity;

import javax.persistence.*;
import com.example.demo.entity.System;
@Entity
@Table(name = "client")
public class Client {
    @Id
    @Column(name = "CLIENT_ID")
    private int clientId;
    @Column(name = "CLIENT_NAME")
    private String clientName;
    @Column(name = "CLIENT_PHONE")
    private String clientPhone;
    @Column(name = "CLIENT_AMOUNT")
    private String clientAmount;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Column(name = "SYS_ID")
    private System system;

}
