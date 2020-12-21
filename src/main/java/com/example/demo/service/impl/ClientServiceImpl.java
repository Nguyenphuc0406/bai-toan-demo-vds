package com.example.demo.service.impl;

import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public String addClient(Client client) {

        if (client != null) {
            clientRepository.save(client);
            return "Saved!";
        } else {
            return "Save Error";
        }
    }
}
