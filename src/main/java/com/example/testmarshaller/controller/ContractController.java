package com.example.testmarshaller.controller;


import com.example.testmarshaller.entiteXML.ContractXML.ContractListXML;
import com.example.testmarshaller.entity.ContractEntity;
import com.example.testmarshaller.helper.ContractHelper;
import com.example.testmarshaller.service.ContractService;
import com.example.testmarshaller.service.RapportXMLService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class ContractController {


    @Autowired
    private ContractService productService;

    @Autowired
    private RapportXMLService rapportXMLService;

    @PostMapping(consumes = "multipart/form-data",value = "/contract/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws Exception {

        Thread.sleep(2000);
        if (ContractHelper.checkExcelFormat(file)) {
            //true

            this.productService.save(file);

            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));


        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }


    @GetMapping("/contract")
    public List<ContractEntity> getAllProduct() {
        return this.productService.getAllProducts();
    }

//    @GetMapping("/contract/xml")
//    public ContractListXML getAllProductxml() throws Exception {
//        return this.productService.listXML();
//    }
//    @GetMapping("/contract/rapportxml")
//    public ContractListXML getAllRapportxml() throws Exception {
//        return this.rapportXMLService.listXML();
//    }

   /*  @GetMapping("/contract/{code}")
    public ContractEntity fetchCode(@PathVariable long code)
    {
        return productService.fetchUsingCode(code);
    } */

    /*@DeleteMapping("/customers/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public void deleteCustomer(@PathVariable Long id){
        bankAccountService.deleteCustomer(id);
    }*/

    @GetMapping("/contract/{id}")
    public ResponseEntity<ContractEntity> getContractById(@PathVariable int id){
        ContractEntity contract = productService.getContractById(id);
        if ( contract== null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(contract);
    }
}
