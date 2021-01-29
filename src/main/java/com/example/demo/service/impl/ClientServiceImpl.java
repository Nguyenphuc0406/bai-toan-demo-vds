package com.example.demo.service.impl;

import com.example.demo.base.response.BadRequestResponse;
import com.example.demo.base.response.BaseResponse;
import com.example.demo.base.response.NotFoundResponse;
import com.example.demo.base.response.OkResponse;
import com.example.demo.config.LocalMessage;
import com.example.demo.entity.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ClientService;
import com.example.demo.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    MasterRepository masterRepository;
    @Autowired
    PartnerRepository partnerRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    PartnerSerRepository partnerSerRepository;
    @Autowired
    PartnerService partnerService;
    @Autowired
    LocalMessage localMessage;
    @Override
    public String addClient(Client client) {

        if (client != null) {
            clientRepository.save(client);
            return "Saved!";
        } else {
            return "Save Error";
        }
    }

    @Override
    public BaseResponse findPartnerByMasterId(int masterId) {
        if (masterId > 0) {
            Master master = masterRepository.findByMasterId(masterId);
            if (master != null) {
                List<Partner> partnerList = partnerRepository.findByMasterPartner(master);
                return new OkResponse(partnerList);
            } else {
                return new NotFoundResponse(localMessage.getErrNotfound());
            }
        } else {
            return new BadRequestResponse(localMessage.getErrInput());
        }

    }

    @Override
    public BaseResponse payment(ClientPayment payment, int partnerId) {
        Partner partner = partnerRepository.findByPartnerId(partnerId);
        if (partner != null) {
            if (payment != null && payment.getPartnerSerId() > 0 && payment.getClientPhone() != null && payment.getAmount() != null) {
                Client client = clientRepository.findByClientPhone(payment.getClientPhone());
                PartnerSer partnerSer = partnerSerRepository.findByPartnerServiceId(payment.getPartnerSerId());

                // check amount client
                if (Integer.parseInt(client.getClientAmount()) >= Integer.parseInt(payment.getAmount())) {
                    // change amount partner
                    PartnerDTO partnerDTO = new PartnerDTO();
                    partnerDTO.setPartnerId(partner.getPartnerId());
                    partnerDTO.setPartnerName(partner.getPartnerName());
                    partnerDTO.setPartnerAmount(Integer.toString(Integer.parseInt(payment.getAmount()) + Integer.parseInt(partner.getPartnerAmount())));
                    partnerDTO.setMasterId(partner.getMasterPartner().getMasterId());
                    partnerService.updatePartner(partner.getPartnerId(), partnerDTO);
                    // change amount client
                    ClientDTO clientDTO = new ClientDTO();
                    clientDTO.setClientId(client.getClientId());
                    clientDTO.setClientName(client.getClientName());
                    clientDTO.setClientPhone(client.getClientPhone());
                    clientDTO.setClientAmount(Integer.toString(Integer.parseInt(client.getClientAmount()) - Integer.parseInt(payment.getAmount())));
                    clientDTO.setPartnerId(client.getPartnerClient().getPartnerId());
                    updateClient(client.getClientId(), clientDTO);

                    // add transaction
                    Transaction transaction = new Transaction();
                    transaction.setClient(client);
                    transaction.setPartnerService(partnerSer);
                    transaction.setTransactionAmount(payment.getAmount());
                    transaction.setTransactionPhone(client.getClientPhone());
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = new Date();
                    transaction.setTransactionTime(dateFormat.format(date));
                    transaction.setPartnerId(partnerId);
                    transactionRepository.save(transaction);
                    return new OkResponse("Thanh toan thanh cong !");
                } else {
                    return new BadRequestResponse("So tien thanh toan khong hop le !");
                }
            } else {
                return new BadRequestResponse(localMessage.getErrInput());
            }
        } else {
            return new NotFoundResponse(localMessage.getErrNotfound());
        }

    }

    @Override
    public BaseResponse updateClient(int clientId, ClientDTO clientDTO) {
        Client clientOld = clientRepository.findByClientId(clientId);
        if (clientOld != null) {
            if (clientDTO != null && clientDTO.getClientId() > 0 && clientDTO.getClientName() != null
                    && clientDTO.getClientAmount() != null) {
                Client client = new Client();
                client.setClientName(clientDTO.getClientName());
                client.setClientPhone(clientDTO.getClientPhone());
                client.setClientAmount(clientDTO.getClientAmount());
                Partner partner = partnerRepository.findByPartnerId(clientDTO.getPartnerId());
                client.setPartnerClient(partner);
                clientRepository.updateClient(client.getClientName(), client.getClientPhone(), client.getClientAmount(),
                        client.getPartnerClient(), clientId);
                return new OkResponse<String>("Update Client succsessfuly !");
            } else {
                return new NotFoundResponse("Input invali!");
            }
        } else {
            return new NotFoundResponse("Client not found!");
        }
    }


}
