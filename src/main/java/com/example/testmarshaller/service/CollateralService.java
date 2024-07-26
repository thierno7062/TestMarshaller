package com.example.testmarshaller.service;


import com.example.testmarshaller.entiteXML.CollateralXML.CollateralXML;
import com.example.testmarshaller.entity.CollateralEntity;
import com.example.testmarshaller.helper.CollateralHelper;
import com.example.testmarshaller.repository.CollateralRepo;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CollateralService {

    @Autowired
    private CollateralRepo collateralRepo;

    public void save(MultipartFile file) throws Exception {

        try {
            List<CollateralEntity> collaterals = CollateralHelper.convertExcelToListOfProduct(file.getInputStream());
            this.collateralRepo.saveAll(collaterals);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<CollateralEntity> getAllProducts() {
        return this.collateralRepo.findAll();
    }



    public CollateralEntity getCollateralById(int id){
        return collateralRepo.findById(id).orElse(null);
    }
}
