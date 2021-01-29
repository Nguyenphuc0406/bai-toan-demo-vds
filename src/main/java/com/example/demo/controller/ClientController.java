package com.example.demo.controller;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.entity.Client;
import com.example.demo.entity.Partner;
import com.example.demo.model.ClientPayment;
import com.example.demo.service.ClientService;

import com.example.demo.service.impl.ClientServiceImpl;
import com.example.demo.utils.ConfigUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping(path = ConfigUrl.URL_CLIENT_SEARCH_PARTNER + "/{id}")
    public BaseResponse getPartnerByMasterId(@PathVariable("id") int masterId) {
        return clientService.findPartnerByMasterId(masterId);
    }
    @PostMapping(path = ConfigUrl.URL_CLIENT_PAYMENT + "/{id}")
    public BaseResponse payment(@RequestBody ClientPayment clientPayment, @PathVariable("id") int partnerId){


        return  clientService.payment(clientPayment, partnerId);
    }
    @PostMapping("/client")
    public String addClient(@RequestBody Client client) {
        if (client != null) {
            clientService.addClient(client);
            return "Saved !";
        } else {
            return "Saved error !";
        }
    }
}
