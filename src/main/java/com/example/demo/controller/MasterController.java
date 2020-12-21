package com.example.demo.controller;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.model.MasterDTO;
import com.example.demo.model.PartnerDTO;
import com.example.demo.service.MasterSerService;
import com.example.demo.service.PartnerSerService;
import com.example.demo.service.impl.PartnerSerServiceImpl;
import com.example.demo.utils.ConfigUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MasterController {
    @Autowired
    MasterSerService masterService;
    @Autowired
    PartnerSerService partnerService;

    @PostMapping(ConfigUrl.URL_MASTER)
    public BaseResponse addSystem(@RequestBody MasterDTO masterDTO) {
        return masterService.addMaster(masterDTO);
    }

    @PostMapping(ConfigUrl.URL_MASTER_AC_PARTNER)
    public BaseResponse addPartner(@RequestBody PartnerDTO partnerDTO) {
        return partnerService.addPartner(partnerDTO);
    }
    @DeleteMapping(path = ConfigUrl.URL_MASTER_AC_PARTNER +"/{id}" )
    public BaseResponse deletePartner(@PathVariable("id") int partnerId){
        return partnerService.delPartner(partnerId);
    }



}
