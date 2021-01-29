package com.example.demo.service.impl;

import com.example.demo.base.response.BadRequestResponse;
import com.example.demo.base.response.BaseResponse;
import com.example.demo.base.response.NotFoundResponse;
import com.example.demo.base.response.OkResponse;
import com.example.demo.config.LocalMessage;
import com.example.demo.entity.Master;
import com.example.demo.entity.MasterSer;
import com.example.demo.entity.Partner;
import com.example.demo.entity.PartnerSer;
import com.example.demo.model.MasterSerOrder;
import com.example.demo.model.MasterSerRegister;
import com.example.demo.model.PartnerDTO;
import com.example.demo.repository.MasterRepository;
import com.example.demo.repository.MasterSerRepository;
import com.example.demo.repository.PartnerRepository;
import com.example.demo.repository.PartnerSerRepository;
import com.example.demo.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartnerServiceImpl implements PartnerService {
    @Autowired
    PartnerRepository partnerRepository;
    @Autowired
    MasterRepository masterRepository;
    @Autowired
    PartnerSerRepository partnerSerRepository;
    @Autowired
    MasterSerRepository masterSerRepository;
    @Autowired
    LocalMessage localMessage;

    @Override
    public BaseResponse addPartner(PartnerDTO partnerDTO) {
        if (partnerDTO != null && partnerDTO.getPartnerName() != null && partnerDTO.getMasterId() > 0) {
            Partner partner = new Partner();
            partner.setPartnerName(partnerDTO.getPartnerName());
            partner.setPartnerAmount(partnerDTO.getPartnerAmount());
            if (masterRepository.findByMasterId(partnerDTO.getMasterId()) != null) {
                Master master = new Master();
                master.setMasterId(partnerDTO.getMasterId());
                partner.setMasterPartner(master);
                partnerRepository.save(partner);
                return new OkResponse(localMessage.getSucAddPartner());
            }
            return new NotFoundResponse(localMessage.getErrNotfound());
        } else {
            return new NotFoundResponse(localMessage.getErrInput());
        }
    }

    @Override
    public BaseResponse delPartner(int partnerId) {
        Partner partner = partnerRepository.findByPartnerId(partnerId);

        if (partner != null) {
            partnerRepository.deletePartnerByPartnerId(partnerId);
            return new OkResponse(localMessage.getSucDelPartner());
        } else {
            return new NotFoundResponse(localMessage.getErrNotfound());
        }
    }

    @Override
    public BaseResponse updatePartner(int partnerId, PartnerDTO partnerDTO) {
        Partner partnerOld = partnerRepository.findByPartnerId(partnerId);
        if (partnerOld != null) {
            if (partnerDTO != null && partnerDTO.getMasterId() > 0 && partnerDTO.getPartnerName() != null
                    && partnerDTO.getPartnerAmount() != null) {
                Partner partnerUp = new Partner();
                partnerUp.setPartnerName(partnerDTO.getPartnerName());
                partnerUp.setPartnerAmount(partnerDTO.getPartnerAmount());
                Master master = masterRepository.findByMasterId(partnerDTO.getMasterId());
                partnerUp.setMasterPartner(master);
                partnerRepository.updatePartner(partnerUp.getPartnerName(), partnerUp.getPartnerAmount(),
                        partnerUp.getMasterPartner(), partnerId);
                return new OkResponse<String>(localMessage.getSucPutPartner());
            } else {
                return new NotFoundResponse("Input invali!");
            }
        } else {
            return new NotFoundResponse("Partner not found!");
        }
    }

    @Override
    public BaseResponse getAllPartner() {
        List<Partner> partners = partnerRepository.findAll();
        List<PartnerSer> partnerSers = partnerSerRepository.findAll();
        List<PartnerDTO> dtoList = new ArrayList<>();
        if (partners != null) {
            for (Partner p : partners) {
                PartnerDTO partnerDTO = new PartnerDTO();
                partnerDTO.setPartnerId(p.getPartnerId());
                partnerDTO.setPartnerName(p.getPartnerName());
                partnerDTO.setPartnerAmount(p.getPartnerAmount());
                partnerDTO.setMasterId(p.getMasterPartner().getMasterId());
                partnerDTO.setPartnerSers(partnerSers);
                dtoList.add(partnerDTO);
            }
            return new OkResponse(dtoList);
        } else {
            return new NotFoundResponse("Partner not found!");
        }
    }

    @Override
    public BaseResponse registerService(MasterSerOrder serOrder) {
        if (serOrder != null && serOrder.getMasterSerRegisters() != null && !serOrder.getMasterSerRegisters().isEmpty()) {

            for (MasterSerRegister m : serOrder.getMasterSerRegisters()) {
                MasterSer masterSer = masterSerRepository.findByMasterServiceId(m.getMasterSerId());
                PartnerSer partnerSer = partnerSerRepository.findByServiceName(masterSer.getServiceName());
                if (partnerSer == null) {
                    PartnerSer ser = new PartnerSer();
                    ser.setServiceName(masterSer.getServiceName());
                    ser.setStatus(masterSer.getStatus());
                    ser.setDescription(masterSer.getDescription());
                    // phai biet duoc thang nao dky dich vu
                    Partner partner = new Partner();
                    partner.setPartnerId(1);
                    ser.setPartner(partner);
                    partnerSerRepository.save(ser);
                    return new OkResponse("Dang ky dich vu thanh cong !");
                } else {
                    return new BadRequestResponse("Dich vu da duoc dang ky !");
                }
            }
        }
        return null;
    }
}
