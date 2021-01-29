package com.example.demo.service;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.model.PartnerDTO;
import com.example.demo.model.PartnerSerDTO;

public interface PartnerSerService {
    public BaseResponse addPartnerSer(PartnerSerDTO partnerSerDTO);
    public BaseResponse delPartnerSer(int partnerSerId);
    public BaseResponse updatePartnerSer(int partnerSerId, PartnerSerDTO partnerSerDTO );
    public BaseResponse getAllPartnerSer();
    public BaseResponse getServiceByPartnerId(int partnerId);
}
