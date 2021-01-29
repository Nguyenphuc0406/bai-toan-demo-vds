package com.example.demo.service;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.entity.Partner;
import com.example.demo.model.MasterSerOrder;
import com.example.demo.model.PartnerDTO;

import java.util.List;

public interface PartnerService {
    public BaseResponse addPartner(PartnerDTO partnerDTO);
    public BaseResponse delPartner(int partnerId);
    public BaseResponse updatePartner(int partnerId,PartnerDTO partnerDTO );
    public BaseResponse getAllPartner();
    public BaseResponse registerService(MasterSerOrder serOrder);

}
