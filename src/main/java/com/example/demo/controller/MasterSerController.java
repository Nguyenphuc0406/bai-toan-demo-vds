package com.example.demo.controller;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.model.MasterSerDTO;
import com.example.demo.service.MasterSerService;
import com.example.demo.utils.ConfigUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MasterSerController {
    @Autowired
    MasterSerService serService;
    @PostMapping(ConfigUrl.URL_MASTER_SERVICE)
    public BaseResponse addMasterService(@RequestBody MasterSerDTO masterSerDTO){
        return serService.addMasterSer(masterSerDTO);
    }

    @GetMapping(ConfigUrl.URL_GET_ALL_MASTER_SER)
    public BaseResponse getAllMasterService(){
        return serService.getAllMasterSer();
    }
}
