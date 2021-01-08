package com.example.demo.service;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.model.MasterSerDTO;
import com.example.demo.model.PartnerSerDTO;

public interface MasterSerService {
    public BaseResponse addMasterSer(MasterSerDTO masterSerDTO);
    public BaseResponse delMasterSer(int masterSerId);
    public BaseResponse updateMasterSer(int masterSerId, MasterSerDTO masterSerDTO );
    public BaseResponse getAllMasterSer();
}
