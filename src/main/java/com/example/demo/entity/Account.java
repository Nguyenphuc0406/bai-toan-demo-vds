package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID")
    private int accountId;
    @NotNull
    @Column(name = "ACCOUNT_NAME")
    private String accountName;
    @NotNull
    @Column(name = "PASSWORD")
    private String password;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY,  optional = false)
    @JoinColumn(name = "ROLE_ID")
    private Role role;


}
