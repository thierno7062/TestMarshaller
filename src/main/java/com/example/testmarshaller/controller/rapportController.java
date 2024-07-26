package com.example.testmarshaller.controller;


import com.example.testmarshaller.entiteXML.ContractXML.ContractListXML;
import com.example.testmarshaller.service.RapportXMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class rapportController {

    @Autowired
    private RapportXMLService rapportXMLService;

     @GetMapping("/rapportxml")
    public ContractListXML getAllRapportxml() throws Exception{
        return this.rapportXMLService.contractListXML();
    }


}
