package com.example.demo.service;

import com.example.demo.base.response.BaseResponse;

public interface TransactionService {
    public BaseResponse getAllTransaction();
    public BaseResponse addTransaction();
    public BaseResponse getDataByPartnerId();
}
