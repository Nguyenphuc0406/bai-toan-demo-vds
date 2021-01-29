package com.example.demo.model;

import lombok.Data;

@Data
public class TransactionDTO {
    private int transId;
    private String transAmount;
    private int clientId;
    private String transPhone;
    private int serviceId;
    private int partnerId;
    private String time;
}
