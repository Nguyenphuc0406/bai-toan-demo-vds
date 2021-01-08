package com.example.demo.model;

import lombok.Data;

@Data
public class ClientPayment {
    private int partnerSerId;
    private String clientPhone;
    private String amount;

}
