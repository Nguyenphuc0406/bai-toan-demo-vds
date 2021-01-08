package com.example.demo.service.impl;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.base.response.NotFoundResponse;
import com.example.demo.base.response.OkResponse;
import com.example.demo.entity.Master;
import com.example.demo.model.MasterDTO;
import com.example.demo.repository.MasterRepository;
import com.example.demo.service.MasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasterServiceImpl implements MasterService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MasterServiceImpl.class);
    @Autowired
    MasterRepository masterRepository;

    @Override
    public BaseResponse addMaster(MasterDTO masterDTO) {
        LOGGER.debug("Bat dau thuc hien them he thong");
       if ((masterDTO != null)){
           Master master = new Master();
           master.setMasterName(masterDTO.getMasterName());
           master.setMasterAmount(masterDTO.getMasterAmount());
           masterRepository.save(master);
           LOGGER.info("Them he thong thanh cong");
           return new OkResponse("Add master Success !");
       }else {
           return new NotFoundResponse("Save error !");
       }
    }
}
