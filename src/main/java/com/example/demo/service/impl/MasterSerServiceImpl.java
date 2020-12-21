package com.example.demo.service.impl;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.base.response.NotFoundResponse;
import com.example.demo.base.response.OkResponse;
import com.example.demo.entity.Master;
import com.example.demo.model.MasterDTO;
import com.example.demo.repository.MasterRepository;
import com.example.demo.service.MasterSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasterSerServiceImpl implements MasterSerService {
    @Autowired
    MasterRepository masterRepository;

    @Override
    public BaseResponse addMaster(MasterDTO masterDTO) {
       if ((masterDTO != null)){
           Master master = new Master();
           master.setMasterName(masterDTO.getMasterName());
           masterRepository.save(master);
           return new OkResponse("Add master Success !");
       }else {
           return new NotFoundResponse("Save error !");
       }
    }
}
