package com.example.testmarshaller.controller;



import com.example.testmarshaller.entity.CollateralEntity;
import com.example.testmarshaller.helper.ContractHelper;
import com.example.testmarshaller.service.CollateralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class CollateralController {

    @Autowired
    private CollateralService collateralService;

    @PostMapping(consumes = "multipart/form-data",value = "/collateral/upload")
    //@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws Exception {

        Thread.sleep(2000);
        if (ContractHelper.checkExcelFormat(file)) {
            //true

            this.collateralService.save(file);

            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));
            

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }

    @GetMapping("/collateral")
    // @PreAuthorize("hasAuthority('SCOPE_USER')")
    public List<CollateralEntity> getAllProduct() {
        return this.collateralService.getAllProducts();
    }

//    @GetMapping("/collateral/xml")
//    // @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
//    public CollateralListXML getAllProductxml() throws Exception {
//        return this.collateralService.listXML();
//    }

    @GetMapping("/collateral/{id}")
    public ResponseEntity<CollateralEntity> getCollateralById(@PathVariable int id){
        CollateralEntity collateral = collateralService.getCollateralById(id);
        if ( collateral== null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(collateral);
    }
}
