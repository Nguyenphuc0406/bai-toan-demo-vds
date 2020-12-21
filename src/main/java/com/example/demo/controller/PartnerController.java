package com.example.demo.controller;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.model.PartnerDTO;
import com.example.demo.service.PartnerSerService;
import com.example.demo.service.impl.PartnerSerServiceImpl;
import com.example.demo.utils.ConfigUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ConfigUrl.URL_PARTNER)
public class PartnerController {
    @Autowired
    PartnerSerService partnerService = new PartnerSerServiceImpl();

//    @GetMapping()
//    public String check(){
//        Partner partner = new Partner();
//        Master master = new Master();
//        partner.setPartnerName("BIDV");
//        partner.setPartnerAmount("0");
//        master.setMasterId(1);
//        partner.setMasterPartner(master);
//        return partnerService.addPartner(partner);
//    }
}
