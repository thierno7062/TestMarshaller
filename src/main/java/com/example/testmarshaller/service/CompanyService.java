package com.example.testmarshaller.service;


import com.example.testmarshaller.entity.CompanyEntity;
import com.example.testmarshaller.helper.CompanyHelper;
import com.example.testmarshaller.repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    public void save(MultipartFile file){
        try{
            List<CompanyEntity> companies = CompanyHelper.convertExcelToListOfelement(file.getInputStream());
            this.companyRepo.saveAll(companies);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<CompanyEntity> getAllProducts(){
        return this.companyRepo.findAll();
    }
}
