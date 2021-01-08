package com.example.demo.controller;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.model.MasterSerOrder;
import com.example.demo.service.PartnerSerService;
import com.example.demo.service.PartnerService;
import com.example.demo.utils.ConfigUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterMasterSerController {
    @Autowired
    PartnerService partnerService;
    @PostMapping(path = ConfigUrl.URL_REGISTER)
    public BaseResponse registerMasterService(@RequestBody MasterSerOrder masterSerOrder){
        return partnerService.registerService(masterSerOrder);
    }
}
