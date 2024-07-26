package com.example.testmarshaller.service;

//import SubjectrolesListXML;

import com.example.testmarshaller.entity.SubjectrolesEntity;
import com.example.testmarshaller.helper.SubjectroleHelper;
import com.example.testmarshaller.repository.SubjectroleRepository;
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
public class Subjectroleservice {

    @Autowired
    private SubjectroleRepository subjectroleRepository;

    public void save(MultipartFile file) throws Exception{

        try{
            List<SubjectrolesEntity> subjectroles = SubjectroleHelper.convertExcelToListOfProduct(file.getInputStream());
            this.subjectroleRepository.saveAll(subjectroles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<SubjectrolesEntity> getAllProducts() {
        return this.subjectroleRepository.findAll();
    }

   /* public Subjectroles getSubjectrolesById(@PathVariable (value = "id") int BTMID_SubjectRoles){
        return subjectroleRepository.findById(BTMID_SubjectRoles)
                .orElseThrow(() -> null);
    }*/


}
