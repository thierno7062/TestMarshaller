package com.example.testmarshaller.controller;


import com.example.testmarshaller.entity.IndividuelEntity;
import com.example.testmarshaller.helper.IndividuelHelper;
import com.example.testmarshaller.service.IndividuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class IndividuelController {

    @Autowired
    private IndividuelService individuelService;

    @PostMapping(consumes = "multipart/form-data",value = "/individual/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws Exception {

        Thread.sleep(2000);
        if (IndividuelHelper.checkExcelFormat(file)) {
            //true

            this.individuelService.save(file);

            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));


        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }


    @GetMapping("/individual")
    public List<IndividuelEntity> getAllProduct() {
        return this.individuelService.getAllProducts();
    }

//    @GetMapping("/individual/xml")
//    public IndividualListXML getAllProductxml() throws Exception {
//        return this.individuelService.listXML();
//    }
}
