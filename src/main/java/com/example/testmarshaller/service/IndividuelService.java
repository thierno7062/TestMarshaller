package com.example.testmarshaller.service;


import com.example.testmarshaller.entity.IndividuelEntity;
import com.example.testmarshaller.helper.IndividuelHelper;
import com.example.testmarshaller.repository.IndividuelRepo;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
@Service
public class IndividuelService {

    @Autowired
    private IndividuelRepo individuelRepo;

    public void save(MultipartFile file) throws Exception {

        try {
            List<IndividuelEntity> individuels = IndividuelHelper.convertExcelToListOfProduct(file.getInputStream());
            this.individuelRepo.saveAll(individuels);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<IndividuelEntity> getAllProducts() {
        return this.individuelRepo.findAll();
    }


}
