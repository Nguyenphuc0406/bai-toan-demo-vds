package com.example.demo.service;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.entity.Client;
import com.example.demo.model.ClientDTO;
import com.example.demo.model.ClientPayment;
import com.example.demo.model.MasterSerOrder;

public interface ClientService {
    public String addClient(Client client);
    public BaseResponse findPartnerByMasterId (int masterId);
    public BaseResponse payment(ClientPayment payment, int partnerId);
    public BaseResponse updateClient(int clientId, ClientDTO clientDTO);
}
