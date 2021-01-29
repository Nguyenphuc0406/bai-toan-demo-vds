package com.example.demo.controller;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.model.PartnerSerDTO;
import com.example.demo.service.PartnerSerService;
import com.example.demo.service.PartnerService;
import com.example.demo.service.impl.PartnerServiceImpl;
import com.example.demo.utils.ConfigUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PartnerController {
    @Autowired
    PartnerService partnerService ;
    @Autowired
    PartnerSerService partnerSerService;
    @PostMapping(ConfigUrl.URL_PARTNER_AC_SERVICE)
    public BaseResponse addService(@RequestBody PartnerSerDTO partnerSerDTO){
        return partnerSerService.addPartnerSer(partnerSerDTO);
    }
    @GetMapping(ConfigUrl.URL_PARTNER_AC_SERVICE)
    public BaseResponse getAllService(){
        return partnerSerService.getAllPartnerSer();
    }
    @DeleteMapping(path = ConfigUrl.URL_PARTNER_AC_SERVICE + "/{id}")
    public BaseResponse deleteService(@PathVariable("id") int partnerSerId){
        return partnerSerService.delPartnerSer(partnerSerId);
    }
    @PutMapping(path = ConfigUrl.URL_PARTNER_AC_SERVICE +"/{id}")
    public BaseResponse updateService(@PathVariable("id") int partnerSerId, @RequestBody PartnerSerDTO partnerSerDTO){
        return partnerSerService.updatePartnerSer(partnerSerId, partnerSerDTO);
    }


}
