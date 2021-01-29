package com.example.demo.controller;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.service.PartnerService;
import com.example.demo.utils.ConfigUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinanceController {
    @Autowired
    PartnerService partnerService;

    @GetMapping(ConfigUrl.URL_FINANCE_GET_PARTNER_INFOR)
    public BaseResponse getAllPartnerInfor() {
        return partnerService.getAllPartner();
    }
}
