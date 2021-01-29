package com.example.demo.service;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.model.MasterDTO;

public interface MasterService {
    public BaseResponse addMaster(MasterDTO masterDTO);
}
