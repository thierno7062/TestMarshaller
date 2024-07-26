package com.example.testmarshaller.controller;

//import SubjectrolesListXML;

import com.example.testmarshaller.entity.SubjectrolesEntity;
import com.example.testmarshaller.helper.SubjectroleHelper;
import com.example.testmarshaller.repository.SubjectroleRepository;
import com.example.testmarshaller.service.Subjectroleservice;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class SubjectroleController {

    private Subjectroleservice subjectroleservice;
    private SubjectroleRepository subjectroleRepository;



    @PostMapping(consumes = "multipart/form-data",value = "/subjectrol/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws Exception {

        Thread.sleep(2000);
        if (SubjectroleHelper.checkExcelFormat(file)) {
            //true

            this.subjectroleservice.save(file);

            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));


        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }

    @GetMapping("/subjectrol")
    public List<SubjectrolesEntity> getAllProduct() {
        return this.subjectroleservice.getAllProducts();
    }

    @GetMapping("/subjectrol/{id}")
    public ResponseEntity<SubjectrolesEntity> getSubjectrolesById(@PathVariable(value = "id") int id)
            throws Exception {
        SubjectrolesEntity subjectroles =
                subjectroleRepository
                        .findById((long) id)
                        .orElseThrow(() -> null);
        return ResponseEntity.ok().body(subjectroles);
    }

//    @GetMapping("/subjectrol/xml")
//    public SubjectrolesListXML getAllProductxml() throws Exception {
//        return this.subjectroleservice.listXML();
//    }
}
