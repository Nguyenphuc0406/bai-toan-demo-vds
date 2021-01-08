package com.example.demo.model;

import lombok.Data;

@Data
public class ClientDTO {

    private int clientId;
    private String clientName;
    private String clientAmount;
    private String clientPhone;
    private int partnerId;
}
