package com.example.demo.service.impl;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.base.response.NotFoundResponse;
import com.example.demo.base.response.OkResponse;
import com.example.demo.entity.Master;
import com.example.demo.entity.Partner;
import com.example.demo.model.PartnerDTO;
import com.example.demo.repository.MasterRepository;
import com.example.demo.repository.PartnerRepository;
import com.example.demo.service.PartnerSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerSerServiceImpl implements PartnerSerService {
    @Autowired
    PartnerRepository partnerRepository;
    @Autowired
    MasterRepository masterRepository;

    @Override
    public BaseResponse addPartner(PartnerDTO partnerDTO) {
        if (partnerDTO != null && partnerDTO.getPartnerName() != null && String.valueOf(partnerDTO.getMasterId()) != null) {
            Partner partner = new Partner();
            partner.setPartnerName(partnerDTO.getPartnerName());
            partner.setPartnerAmount(partnerDTO.getPartnerAmount());

            if (masterRepository.findByMasterId(partnerDTO.getMasterId()) != null) {
                Master master = new Master();
                master.setMasterId(partnerDTO.getMasterId());
                partner.setMasterPartner(master);
                partnerRepository.save(partner);
                return new OkResponse("Add partner success !");
            }
            return new NotFoundResponse("Input invali!");
        } else {
            return new NotFoundResponse("Save error !");
        }
    }

    @Override
    public BaseResponse delPartner(int partnerId) {
        Partner partner = new Partner();
        partner = partnerRepository.findByPartnerId(partnerId);
        if (partner != null) {
            partnerRepository.deletePartnerByPartnerId(partnerId);
            return new OkResponse<String>("Delete partner successfuly!");
        }else {
            return new NotFoundResponse("Partner not found!");
        }
    }

    @Override
    public BaseResponse updatePartner(int partnerId, PartnerDTO partnerDTO) {
        Partner partnerOld = partnerRepository.findByPartnerId(partnerId);
        if (partnerOld != null){
            if (partnerDTO != null )
        Partner partnerUp = new Partner();
        partnerUp.setPartnerAmount(partnerOld.getPartnerAmount());
        partnerUp.setPartnerName(partnerOld.getPartnerName());

        }else {

        }
        return null;
    }

    @Override
    public List<Partner> getAllPartner() {
        return null;
    }
}
