package com.example.testmarshaller.controller;


import com.example.testmarshaller.entity.CompanyEntity;
import com.example.testmarshaller.helper.CompanyHelper;
import com.example.testmarshaller.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping(consumes = "multipart/form-data",value = "/company/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws InterruptedException{

        Thread.sleep(2000);
        if (CompanyHelper.checkExcelFormat(file)) {
            //true

            this.companyService.save(file);

            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));


        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }
    @GetMapping("/company")
    public List<CompanyEntity> getAllProduct() {
        return this.companyService.getAllProducts();
    }
}
