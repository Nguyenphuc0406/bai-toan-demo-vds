package com.example.demo.service.impl;

import com.example.demo.base.response.BadRequestResponse;
import com.example.demo.base.response.BaseResponse;
import com.example.demo.base.response.NotFoundResponse;
import com.example.demo.base.response.OkResponse;
import com.example.demo.entity.Master;
import com.example.demo.entity.Partner;
import com.example.demo.entity.PartnerSer;
import com.example.demo.model.PartnerDTO;
import com.example.demo.model.PartnerSerDTO;
import com.example.demo.repository.PartnerRepository;
import com.example.demo.repository.PartnerSerRepository;
import com.example.demo.service.PartnerSerService;
import com.example.demo.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartnerSerServiceImpl implements PartnerSerService {
    @Autowired
    PartnerSerRepository serRepository;
    @Autowired
    PartnerRepository partnerRepository;

    @Override
    public BaseResponse addPartnerSer(PartnerSerDTO partnerSerDTO) {
        if (partnerSerDTO != null && partnerSerDTO.getServiceName() != null && partnerSerDTO.getPartnerId() > 0
                && partnerSerDTO.getServiceStatus() != null) {
            PartnerSer partnerSer = new PartnerSer();
            partnerSer.setServiceName(partnerSerDTO.getServiceName());
            partnerSer.setDescription(partnerSerDTO.getServiceDesc());
            if (partnerRepository.findByPartnerId(partnerSerDTO.getPartnerId()) != null) {
                Partner partner = new Partner();
                partner.setPartnerId(partnerSerDTO.getPartnerId());
                if (partnerSerDTO.getServiceStatus().equals("active") || partnerSerDTO.getServiceStatus().equals("disable")) {
                    partnerSer.setStatus(partnerSerDTO.getServiceStatus());
                    partnerSer.setPartner(partner);
                    serRepository.save(partnerSer);
                    return new OkResponse("Doi tac them dich vu thanh cong");
                } else {
                    return new BadRequestResponse("Trang thai dich vu phai active hoac disable");
                }
            } else {
                return new NotFoundResponse("Khong tim thay ma doi tac");
            }
        } else {
            return new BadRequestResponse("Thieu cac truong thong tin");
        }
    }

    @Override
    public BaseResponse delPartnerSer(int partnerSerId) {
        PartnerSer partnerSer = serRepository.findByPartnerServiceId(partnerSerId);

        if (partnerSer != null) {
            serRepository.deletePartnerByPartnerSerId(partnerSerId);
            return new OkResponse<String>("Xoa dich vu thanh cong");
        } else {
            return new NotFoundResponse("Khong tim thay dich vu can xoa");
        }
    }

    @Override
    public BaseResponse updatePartnerSer(int partnerSerId, PartnerSerDTO partnerSerDTO) {
        PartnerSer partnerSer = serRepository.findByPartnerServiceId(partnerSerId);
        if (partnerSer != null) {
            PartnerSer serviceUp = new PartnerSer();
            serviceUp.setDescription(partnerSerDTO.getServiceDesc());
            serviceUp.setStatus(partnerSerDTO.getServiceStatus());
            serviceUp.setServiceName(partnerSerDTO.getServiceName());
            serviceUp.setDescription(partnerSerDTO.getServiceDesc());
            Partner partner = partnerRepository.findByPartnerId(partnerSerDTO.getPartnerId());
            if (partner != null) {
                serviceUp.setPartner(partner);
                serRepository.updatePartnerSer(serviceUp.getServiceName(), serviceUp.getDescription(),
                        serviceUp.getPartner(), serviceUp.getStatus(), partnerSerId);
                return new OkResponse<String>("Update partner service successfuly!");
            } else {
                return new NotFoundResponse("Partner not found!");
            }

        } else {
            return new BadRequestResponse("Input invali!");
        }

    }

    @Override
    public BaseResponse getAllPartnerSer() {
        List<PartnerSer> partnerSers = serRepository.findAll(
        );

        List<PartnerSerDTO> dtoList = new ArrayList<>();
        if (partnerSers != null) {
            for (PartnerSer ps : partnerSers) {
                PartnerSerDTO serDTO = new PartnerSerDTO();
                serDTO.setPartnerSerId(ps.getPartnerServiceId());
                serDTO.setServiceDesc(ps.getDescription());
                serDTO.setServiceName(ps.getServiceName());
                serDTO.setServiceStatus(ps.getStatus());
                serDTO.setPartnerId(ps.getPartner().getPartnerId());
                dtoList.add(serDTO);
            }
            return new OkResponse(dtoList);
        } else {
            return new NotFoundResponse("Partner service not found!");
        }
    }

    @Override
    public BaseResponse getServiceByPartnerId(int partnerId) {

        return null;
    }
}
