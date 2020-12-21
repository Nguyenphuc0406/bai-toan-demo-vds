package com.example.demo.controller;

import com.example.demo.entity.Client;
import com.example.demo.entity.Partner;
import com.example.demo.service.ClientService;

import com.example.demo.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @Autowired
    ClientService clientService = new ClientServiceImpl();
    @GetMapping("/client")
    public String addClient(){
        Client client = new Client();
        Partner partner = new Partner();
//        client.setClientId(1);
        client.setClientName("Nguyen Hoang Anh");
        client.setClientPhone("0123456789");
        client.setClientAmount("1200000");
        partner.setPartnerId(1);
        client.setPartnerClient(partner);
        clientService.addClient(client);
        return "Saved!";
    }
    @PostMapping("/client")
    public String addClient(@RequestBody Client client){
       if (client != null){
           clientService.addClient(client);
           return "Saved !";
       }else {
           return "Saved error !";
       }
    }
}
