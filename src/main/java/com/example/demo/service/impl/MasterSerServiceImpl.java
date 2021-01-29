package com.example.demo.service.impl;

import com.example.demo.base.response.BadRequestResponse;
import com.example.demo.base.response.BaseResponse;
import com.example.demo.base.response.NotFoundResponse;
import com.example.demo.base.response.OkResponse;
import com.example.demo.config.LocalMessage;
import com.example.demo.entity.Master;
import com.example.demo.entity.MasterSer;
import com.example.demo.entity.Partner;
import com.example.demo.model.MasterSerDTO;
import com.example.demo.model.PartnerDTO;
import com.example.demo.repository.MasterSerRepository;
import com.example.demo.service.MasterSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MasterSerServiceImpl implements MasterSerService {
    @Autowired
    MasterSerRepository serRepository;
    @Autowired
    LocalMessage localMessage;
    @Override
    public BaseResponse addMasterSer(MasterSerDTO masterSerDTO) {
        if (masterSerDTO != null) {
            Master master = new Master();
            master.setMasterId(masterSerDTO.getMasterId());
            MasterSer masterSer = new MasterSer();
            masterSer.setServiceName(masterSerDTO.getMasterSerName());
            masterSer.setDescription(masterSerDTO.getMasterSerDesc());
            masterSer.setStatus(masterSerDTO.getMasterSerStatus());
            masterSer.setMasterService(master);
            serRepository.save(masterSer);
            return new OkResponse(localMessage.getSucAddMasterService());
        } else {
            return new BadRequestResponse(localMessage.getErrInput());
        }

    }

    @Override
    public BaseResponse delMasterSer(int masterSerId) {
        return null;
    }

    @Override
    public BaseResponse updateMasterSer(int masterSerId, MasterSerDTO masterSerDTO) {
        return null;
    }

    @Override
    public BaseResponse getAllMasterSer() {
        List<MasterSer> masterSers = serRepository.findAll();
        List<MasterSerDTO> dtoList = new ArrayList<>();
        if (masterSers != null) {
            for (MasterSer p : masterSers) {
                MasterSerDTO serDTO = new MasterSerDTO();
                serDTO.setMasterSerId(p.getMasterServiceId());
                serDTO.setMasterSerName(p.getServiceName());
                serDTO.setMasterSerDesc(p.getDescription());
                serDTO.setMasterSerStatus(p.getStatus());
                serDTO.setMasterId(p.getMasterService().getMasterId());
                dtoList.add(serDTO);
            }
            return new OkResponse(dtoList);
        } else {
            return new NotFoundResponse("Master service not found!");
        }
    }
}
