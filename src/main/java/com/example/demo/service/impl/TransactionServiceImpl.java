package com.example.demo.service.impl;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.base.response.NotFoundResponse;
import com.example.demo.base.response.OkResponse;
import com.example.demo.config.LocalMessage;
import com.example.demo.entity.PartnerSer;
import com.example.demo.entity.Transaction;
import com.example.demo.model.TransactionDTO;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.PartnerService;
import com.example.demo.service.TransactionService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    LocalMessage localMessage;
    @Override
    public BaseResponse getAllTransaction() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionDTO> dtoList = new ArrayList<>();
        if (transactions !=null){
            for (Transaction t : transactions){
                TransactionDTO transactionDTO = new TransactionDTO();
                transactionDTO.setTransId(t.getTransactionId());
                transactionDTO.setTransAmount(t.getTransactionAmount());
                transactionDTO.setTransPhone(t.getTransactionPhone());
                transactionDTO.setTime(t.getTransactionTime());
                transactionDTO.setClientId(t.getClient().getClientId());
                transactionDTO.setPartnerId(t.getPartnerId());
                transactionDTO.setServiceId(t.getPartnerService().getPartnerServiceId());
                dtoList.add(transactionDTO);
            }
            return new OkResponse(dtoList);
        } else {
            return new NotFoundResponse(localMessage.getErrNotfound());
        }

    }

    @Override
    public BaseResponse addTransaction() {
        return null;
    }

    @Override
    public BaseResponse getDataByPartnerId() {
        return null;
    }
}
