package com.example.testmarshaller.service;


import com.example.testmarshaller.entity.ContractEntity;
import com.example.testmarshaller.helper.ContractHelper;
import com.example.testmarshaller.repository.CollateralRepo;
import com.example.testmarshaller.repository.ContractRepo;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
@Service
@Slf4j
@AllArgsConstructor
public class ContractService {

    private ContractRepo contractRepo;
    private CollateralRepo collateralRepo;

    public void save(MultipartFile file) throws Exception {

        try {
            List<ContractEntity> products = ContractHelper.convertExcelToListOfProduct(file.getInputStream());
            this.contractRepo.saveAll(products);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<ContractEntity> getAllProducts() {
        return this.contractRepo.findAll();
    }


    public List<ContractEntity> getOne(int code) {
        return contractRepo.findAllByContractCode(code);
    }

   /*  public ContractEntity fetchUsingCode(Long code) {
        return contractRepo.fetchUsingCode(code);
    } */

    public ContractEntity getContractById(int id) {
        return contractRepo.findById(id).orElse(null);
    }
}
