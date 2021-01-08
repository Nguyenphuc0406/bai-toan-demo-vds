package com.example.demo.controller;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.service.TransactionService;
import com.example.demo.utils.ConfigUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @GetMapping(ConfigUrl.URL_FINANCE_GET_TRANSACTION)
    public BaseResponse getAllTransaction(){
    return transactionService.getAllTransaction();
    }
}
